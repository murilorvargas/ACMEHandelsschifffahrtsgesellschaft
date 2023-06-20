package gui.components;

import javax.swing.*;

import fileReader.FileReader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainApplication;
import shared.errors.BaseRunTimeException;

public class FileReadMenu extends JFrame {

    // Componentes principais
    private JTextField nameField;
    private JButton cargoButton;
    private JButton cargoTypeButton;
    private JButton clientButton;
    private JButton harborButton;
    private JButton harborDistanceButton;
    private JButton shipButton;
    private JButton backButton;
    private JLabel message;

    private String fileName;
    private FileReader fileReader;

    public FileReadMenu() {
        super();
        fileReader = new FileReader();
        // Título do formulário
        JLabel formTitle = new JLabel("Leitura de Arquivos");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // Painel para campos de entrada
        GridLayout gridCampos = new GridLayout(7, 7);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel nameLabel = new JLabel("Nome do arquivo:");
        nameField = new JTextField();
        painelCampos.add(nameLabel);
        painelCampos.add(nameField);

        // Tratamento de evento do botão "Cadastrar Carga"
        cargoButton = new JButton("Cadastrar Carga");
        cargoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName = nameField.getText();
                if (fileName.equals("")) {
                    message.setText("Por favor, insira o nome do arquivo.");
                } else {
                    readFile("cargo");
                }
            }
        });

        cargoTypeButton = new JButton("Cadastrar Tipo de Carga");
        clientButton = new JButton("Cadastrar Cliente");
        harborButton = new JButton("Cadastrar Porto");
        harborDistanceButton = new JButton("Cadastrar Distância dos Portos");
        shipButton = new JButton("Cadastrar Navio");

        backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainApplication();
                setVisible(false);
            }
        });
        message = new JLabel();

        // Painel principal
        GridLayout grid = new GridLayout(3, 3);
        JPanel painel = new JPanel(grid);
        painel.add(formTitle);
        painel.add(message);

        // Painel para os botões
        GridLayout gridButton = new GridLayout(3, 3);
        JPanel painelButtons = new JPanel(gridButton);
        FlowLayout botaoLayout = new FlowLayout(FlowLayout.CENTER);
        JPanel botaoPainel = new JPanel(botaoLayout);
        painelButtons.add(cargoButton);
        painelButtons.add(cargoTypeButton);
        painelButtons.add(clientButton);
        painelButtons.add(harborButton);
        painelButtons.add(harborDistanceButton);
        painelButtons.add(shipButton);
        painelButtons.add(backButton);

        // Adicionar os painéis ao JFrame
        this.setTitle("Main Menu");
        this.setLayout(new BorderLayout());
        this.add(painel, BorderLayout.NORTH);
        this.add(painelCampos, BorderLayout.CENTER);
        this.add(painelButtons, BorderLayout.SOUTH);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        FileReadMenu window = new FileReadMenu();
    }

    private void readFile(String type) {
        try {
            fileReader.readFile(fileName, type);
        } catch (BaseRunTimeException e) {
            message.setText(e.getTranslation());
            return;
        } catch (Exception e) {
            message.setText("Erro ao ler o arquivo.");
            return;
        }
        new MainApplication();
        setVisible(false);
    }
}