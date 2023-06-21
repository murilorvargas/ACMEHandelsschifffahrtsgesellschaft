package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;
import modules.cargo.CargoController;
import modules.cargo.entities.Cargo;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargoRegisterForm extends JFrame {

    private JTextField idField;
    private JTextField weightField;
    private JTextField declaredValueField;
    private JTextField maxTimeField;
    private JTextField priorityField;
    private JTextField cargoTypeNumberField;
    private JTextField originHarborIdField;
    private JTextField destinationHarborIdField;
    private JTextField clientIdField;
    private JButton registerButton;
    private JButton clearButton;
    private JButton backButton;
    private JLabel message;

    private int id;
    private double weight;
    private double declaredValue;
    private int maxTime;
    private String priority;
    private int cargoTypeNumber;
    private int originHarborId;
    private int destinationHarborId;
    private int clientId;
    private CargoController cargoController;

    public CargoRegisterForm() {
        super();
        cargoController = new CargoController();

        JLabel formTitle = new JLabel("Cadastre uma Nova Carga");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GridLayout gridCampos = new GridLayout(5, 2);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel weightLabel = new JLabel("Peso:");
        weightField = new JTextField();
        JLabel declaredValueLabel = new JLabel("Valor declarado:");
        declaredValueField = new JTextField();
        JLabel maxTimeLabel = new JLabel("Tempo Máximo:");
        maxTimeField = new JTextField();
        JLabel priorityLabel = new JLabel("Prioridade:");
        priorityField = new JTextField();
        JLabel cargoTypeNumberLabel = new JLabel("Número do tipo da carga:");
        cargoTypeNumberField = new JTextField();
        JLabel originHarborIdLabel = new JLabel("ID da origem:");
        originHarborIdField = new JTextField();
        JLabel destinationHarborIdLabel = new JLabel("ID do destino:");
        destinationHarborIdField = new JTextField();
        JLabel clientIdLabel = new JLabel("ID do cliente:");
        clientIdField = new JTextField();

        painelCampos.add(idLabel);
        painelCampos.add(idField);
        painelCampos.add(weightLabel);
        painelCampos.add(weightField);
        painelCampos.add(declaredValueLabel);
        painelCampos.add(declaredValueField);
        painelCampos.add(maxTimeLabel);
        painelCampos.add(maxTimeField);
        painelCampos.add(priorityLabel);
        painelCampos.add(priorityField);
        painelCampos.add(cargoTypeNumberLabel);
        painelCampos.add(cargoTypeNumberField);
        painelCampos.add(originHarborIdLabel);
        painelCampos.add(originHarborIdField);
        painelCampos.add(destinationHarborIdLabel);
        painelCampos.add(destinationHarborIdField);
        painelCampos.add(clientIdLabel);
        painelCampos.add(clientIdField);

        registerButton = new JButton("Cadastrar");
        clearButton = new JButton("Limpar Campos");
        backButton = new JButton("Voltar");
        message = new JLabel();

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id = Integer.parseInt(idField.getText());
                } catch (NumberFormatException exception) {
                    message.setText("O ID deve ser um número inteiro.");
                    return;
                }
                try {
                    weight = Double.parseDouble(weightField.getText());
                } catch (NumberFormatException exception) {
                    message.setText("O peso deve ser um número decimal.");
                    return;
                }
                try {
                    declaredValue = Double.parseDouble(declaredValueField.getText());
                } catch (NumberFormatException exception) {
                    message.setText("O valor declarado deve ser um número decimal.");
                    return;
                }
                try {
                    maxTime = Integer.parseInt(maxTimeField.getText());
                } catch (NumberFormatException exception) {
                    message.setText("O tempo máximo deve ser um número inteiro.");
                    return;
                }
                try {
                    cargoTypeNumber = Integer.parseInt(cargoTypeNumberField.getText());
                } catch (NumberFormatException exception) {
                    message.setText("O número do tipo da carga deve ser um número inteiro.");
                    return;
                }
                try {
                    originHarborId = Integer.parseInt(originHarborIdField.getText());
                } catch (NumberFormatException exception) {
                    message.setText("O ID da origem deve ser um número inteiro.");
                    return;
                }
                try {
                    destinationHarborId = Integer.parseInt(destinationHarborIdField.getText());
                } catch (NumberFormatException exception) {
                    message.setText("O ID do destino deve ser um número inteiro.");
                    return;
                }
                try {
                    clientId = Integer.parseInt(clientIdField.getText());
                } catch (NumberFormatException exception) {
                    message.setText("O ID do cliente deve ser um número inteiro.");
                    return;
                }
                priority = priorityField.getText();

                try {
                    cargoRegister();
                } catch (BaseRunTimeException exception) {
                    message.setText(exception.getTranslation());
                    return;
                }

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                weightField.setText("");
                declaredValueField.setText("");
                maxTimeField.setText("");
                priorityField.setText("");
                cargoTypeNumberField.setText("");
                originHarborIdField.setText("");
                destinationHarborIdField.setText("");
                clientIdField.setText("");
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
        botaoPainel.add(registerButton);
        botaoPainel.add(clearButton);
        botaoPainel.add(backButton);

        this.setTitle("Cadastro de Carga");
        this.setLayout(new BorderLayout());
        this.add(painel, BorderLayout.NORTH);
        this.add(botaoPainel, BorderLayout.SOUTH);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        CargoRegisterForm janela = new CargoRegisterForm();
    }

    private void cargoRegister() {
        try {
            cargoController.onCreateCargo(id, weight, declaredValue, maxTime, priority, cargoTypeNumber,
                    originHarborId, destinationHarborId, clientId);
        } catch (BaseRunTimeException e) {
            message.setText(e.getTranslation());
            return;
        } catch (Exception e) {
            message.setText("Erro ao ler o arquivo.");
            return;
        }
        new RegisterMenu();
        setVisible(false);
    }
}