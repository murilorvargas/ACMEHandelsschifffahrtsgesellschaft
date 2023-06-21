package gui.components;

import javax.swing.*;

import fileReader.FileReader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainApplication;
import shared.errors.BaseRunTimeException;

public class FileReadMenu extends JFrame {

    private JTextField nameField;
    private JButton cargoButton;
    private JButton cargoTypeButton;
    private JButton clientButton;
    private JButton harborButton;
    private JButton harborDistanceButton;
    private JButton shipButton;
    private JButton backButton;
    private JButton readAllButton;
    private JLabel message;

    private String fileName;
    private FileReader fileReader;

    public FileReadMenu() {
        super();
        fileReader = new FileReader();
        JLabel formTitle = new JLabel("Leitura de Arquivos");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GridLayout gridCampos = new GridLayout(7, 7);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel nameLabel = new JLabel("Nome do arquivo:");
        nameField = new JTextField();
        painelCampos.add(nameLabel);
        painelCampos.add(nameField);

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
        cargoTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName = nameField.getText();
                if (fileName.equals("")) {
                    message.setText("Por favor, insira o nome do arquivo.");
                } else {
                    readFile("cargoType");
                }
            }
        });
        clientButton = new JButton("Cadastrar Cliente");
        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName = nameField.getText();
                if (fileName.equals("")) {
                    message.setText("Por favor, insira o nome do arquivo.");
                } else {
                    readFile("client");
                }
            }
        });
        harborButton = new JButton("Cadastrar Porto");
        harborButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName = nameField.getText();
                if (fileName.equals("")) {
                    message.setText("Por favor, insira o nome do arquivo.");
                } else {
                    readFile("harbor");
                }
            }
        });
        harborDistanceButton = new JButton("Cadastrar Distância dos Portos");
        harborDistanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName = nameField.getText();
                if (fileName.equals("")) {
                    message.setText("Por favor, insira o nome do arquivo.");
                } else {
                    readFile("harborDistance");
                }
            }
        });

        shipButton = new JButton("Cadastrar Navio");
        shipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName = nameField.getText();
                if (fileName.equals("")) {
                    message.setText("Por favor, insira o nome do arquivo.");
                } else {
                    readFile("ship");
                }
            }
        });

        readAllButton = new JButton("Cadastrar Todos");

        readAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileName = nameField.getText();
                if (fileName.equals("")) {
                    message.setText("Por favor, insira o nome do arquivo.");
                } else {
                    readFile("all");
                }
            }
        });

        backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainApplication();
                setVisible(false);
            }
        });
        message = new JLabel();

        GridLayout grid = new GridLayout(3, 3);
        JPanel painel = new JPanel(grid);
        painel.add(formTitle);
        painel.add(message);

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
        painelButtons.add(readAllButton);
        painelButtons.add(backButton);

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
            if (type.equals("all")) {
                fileReader.readFile(fileName + "-PORTOS", "harbor");
                fileReader.readFile(fileName + "-DISTANCIAS", "harborDistance");
                fileReader.readFile(fileName + "-NAVIOS", "ship");
                fileReader.readFile(fileName + "-CLIENTES", "client");
                fileReader.readFile(fileName + "-TIPOSCARGAS", "cargoType");
                fileReader.readFile(fileName + "-CARGAS", "cargo");
            } else {
                fileReader.readFile(fileName, type);
            }
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