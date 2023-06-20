package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.components.FileReadMenu;
import gui.components.ListMenu;
import gui.components.RegisterMenu;

public class MainApplication extends JFrame {

    // Componentes principais
    private JButton fileReadButton;
    private JButton manualInputButton;
    private JButton listButton;
    private JButton quitButton;

    public MainApplication() {
        super();

        // Título do formulário
        JLabel formTitle = new JLabel("ACME Handelsschifffahrtsgesellschaft");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // Botões
        fileReadButton = new JButton("Cadastrar por meio da leitura de arquivo");
        manualInputButton = new JButton("Cadastrar Manualmente");
        listButton = new JButton("Listar");
        quitButton = new JButton("Sair");

        // Tratamento de evento do botão cadastrar por meio da leitura de arquivo
        fileReadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FileReadMenu();
                setVisible(false);
            }
        });

        // Tratamento de evento do botão cadastrar manualmente
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

        // Tratamento de evento do botão sair
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Painel principal
        JPanel painel = new JPanel(new GridLayout(2, 1));
        painel.add(formTitle);

        // Painel para os botões
        JPanel botaoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPainel.add(fileReadButton);
        botaoPainel.add(manualInputButton);
        botaoPainel.add(listButton);
        botaoPainel.add(quitButton);
        painel.add(botaoPainel);

        // Configurações da janela
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