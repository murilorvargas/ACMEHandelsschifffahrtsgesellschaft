package gui.components;

import javax.swing.*;

import gui.MainApplication;
import gui.forms.CargoRegisterForm;
import gui.forms.CargoTypeRegisterForm;
import gui.forms.ClientRegisterForm;
import gui.forms.HarborRegisterForm;
import gui.forms.ShipRegisterForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterMenu extends JFrame {

    private JButton cargoButton;
    private JButton cargoTypeButton;
    private JButton clientButton;
    private JButton harborButton;
    private JButton shipButton;
    private JButton backButton;

    public RegisterMenu() {
        super();

        JLabel formTitle = new JLabel("Leitura de Arquivos");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        cargoButton = new JButton("Cadastrar Carga");
        cargoTypeButton = new JButton("Cadastrar Tipo de Carga");
        clientButton = new JButton("Cadastrar Cliente");
        harborButton = new JButton("Cadastrar Porto");
        shipButton = new JButton("Cadastrar Navio");
        backButton = new JButton("Voltar");

        cargoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CargoRegisterForm();
                setVisible(false);
            }
        });

        cargoTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CargoTypeRegisterForm();
                setVisible(false);
            }
        });

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientRegisterForm();
                setVisible(false);
            }
        });

        harborButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HarborRegisterForm();
                setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainApplication();
                setVisible(false);
            }
        });

        shipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShipRegisterForm();
                setVisible(false);
            }
        });

        JPanel painel = new JPanel(new GridLayout(2, 2));
        painel.add(formTitle);

        JPanel botaoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPainel.add(cargoButton);
        botaoPainel.add(cargoTypeButton);
        botaoPainel.add(clientButton);
        botaoPainel.add(harborButton);
        botaoPainel.add(shipButton);
        botaoPainel.add(backButton);
        painel.add(botaoPainel);

        this.setTitle("Main Menu");
        this.add(painel);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        RegisterMenu window = new RegisterMenu();
    }
}