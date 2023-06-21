package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.components.FileReadMenu;
import gui.components.ListMenu;
import gui.components.RegisterMenu;
import modules.cargo.CargoController;
import modules.freight.FreightController;
import shared.errors.BaseRunTimeException;

public class MainApplication extends JFrame {

    private JTextField nameFreightField;
    private JButton submitButton;

    private JButton fileReadButton;
    private JButton manualInputButton;
    private JButton listButton;
    private JButton upDateFreightButton;
    private JButton deleteFreightButton;
    private JButton quitButton;
    private JLabel message;

    private FreightController freightController;

    public MainApplication() {
        super();
        freightController = new FreightController();

        JLabel formTitle = new JLabel("ACME Handelsschifffahrtsgesellschaft");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GridLayout gridCampos = new GridLayout(5, 5);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel nameFreightLabel = new JLabel("ID do Frete:");
        nameFreightField = new JTextField();
        submitButton = new JButton("Finalizar!");

        painelCampos.add(nameFreightLabel);
        painelCampos.add(nameFreightField);
        painelCampos.add(submitButton);

        nameFreightField.setEnabled(false);
        nameFreightField.setVisible(false);
        nameFreightLabel.setVisible(false);
        submitButton.setVisible(false);
        fileReadButton = new JButton("Cadastrar por meio da leitura de arquivo");
        manualInputButton = new JButton("Cadastrar Manualmente");
        listButton = new JButton("Listar");
        upDateFreightButton = new JButton("Atualizar Lista de Fretes Pendentes");
        deleteFreightButton = new JButton("Finalizar Frete");
        quitButton = new JButton("Sair");
        message = new JLabel();

        fileReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FileReadMenu();
                setVisible(false);
            }
        });

        manualInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMenu();
                setVisible(false);
            }
        });

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListMenu();
                setVisible(false);
            }
        });

        upDateFreightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    freightController.onCreateFreights();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao atualizar fretes.");
                    return;
                }
                message.setText("Lista de fretes atualizada com sucesso!");
            }
        });

        deleteFreightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameFreightField.setEnabled(true);
                nameFreightField.setVisible(true);
                nameFreightLabel.setVisible(true);
                submitButton.setVisible(true);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id;
                try {
                    id = nameFreightField.getText();
                } catch (Exception a) {
                    message.setText("Erro ao finalizar frete.");
                    return;
                }
                if (id.equals("")) {
                    message.setText("Preencha o campo de ID.");
                    return;
                }
                try {
                    freightController.onFinishFreight(id);
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao finalizar frete.");
                    return;
                }
                message.setText("Frete finalizado com sucesso!");

                nameFreightField.setEnabled(false);
                nameFreightField.setVisible(false);
                nameFreightLabel.setVisible(false);
                submitButton.setVisible(false);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel botaoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPainel.add(fileReadButton);
        botaoPainel.add(manualInputButton);
        botaoPainel.add(listButton);
        botaoPainel.add(upDateFreightButton);
        botaoPainel.add(deleteFreightButton);
        botaoPainel.add(quitButton);

        JPanel painel = new JPanel(new GridLayout(4, 1));
        painel.add(formTitle);
        painel.add(message);
        painel.add(botaoPainel);
        painel.add(painelCampos, BorderLayout.SOUTH);

        this.setTitle("Main Menu");
        this.add(painel);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MainApplication window = new MainApplication();
    }
}