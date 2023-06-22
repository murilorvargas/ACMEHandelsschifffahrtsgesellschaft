package gui.components;

import javax.swing.*;

import fileSaver.FileSaver;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileSave extends JFrame {

    private JTextField fileName;
    private JButton saveAllButton;
    private JButton clearButton;
    private JButton backButton;
    private JLabel message;

    public FileSave() {
        super();

        JLabel formTitle = new JLabel("Salvar Arquivo");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GridLayout gridCampos = new GridLayout(5, 2);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel fileLabel = new JLabel("Nome do Arquivo:");
        fileName = new JTextField();

        painelCampos.add(fileLabel);
        painelCampos.add(fileName);

        saveAllButton = new JButton("Salvar");
        clearButton = new JButton("Limpar Campos");
        backButton = new JButton("Voltar");
        message = new JLabel();

        saveAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileSaver fileSaver = new FileSaver();
                    fileSaver.saveFile(fileName.getText() + "-PORTOS", "harbor");
                    fileSaver.saveFile(fileName.getText() + "-DISTANCIAS", "harborDistance");
                    fileSaver.saveFile(fileName.getText() + "-NAVIOS", "ship");
                    fileSaver.saveFile(fileName.getText() + "-CLIENTES", "client");
                    fileSaver.saveFile(fileName.getText() + "-TIPOSCARGAS", "cargoType");
                    fileSaver.saveFile(fileName.getText() + "-CARGAS", "cargo");
                    fileSaver.saveFile(fileName.getText() + "-FRETES", "freight");

                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao salvar dados.");
                    return;
                }
                new RegisterMenu();
                setVisible(false);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName.setText("");
                message.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMenu();
                setVisible(false);
            }
        });

        JPanel painel = new JPanel(new GridLayout(3, 1));
        painel.add(formTitle);
        painel.add(painelCampos);
        painel.add(message);

        JPanel botaoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPainel.add(saveAllButton);
        botaoPainel.add(clearButton);
        botaoPainel.add(backButton);

        this.setTitle("Salvar Arquivos");
        this.setLayout(new BorderLayout());
        this.add(painel, BorderLayout.NORTH);
        this.add(botaoPainel, BorderLayout.SOUTH);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FileSave();
    }
}
