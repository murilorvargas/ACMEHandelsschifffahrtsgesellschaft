package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargoRegisterForm extends JFrame {

    // Componentes principais
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

    public CargoRegisterForm() {
        super();

        // Título do formulário
        JLabel formTitle = new JLabel("Cadastre uma Nova Carga");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // Painel para campos de entrada
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

        // Botões
        registerButton = new JButton("Cadastrar");
        clearButton = new JButton("Limpar Campos");
        backButton = new JButton("Voltar");
        message = new JLabel();

        // Tratamento de evento do botão cadastrar
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar a carga
            }
        });

        // Tratamento de evento do botão limpar
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para limpar os campos
            }
        });

        // Tratamento de evento do botão voltar
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMenu();
                setVisible(false);
            }
        });

        // Painel principal
        JPanel painel = new JPanel(new GridLayout(2, 1));
        painel.add(formTitle);
        painel.add(painelCampos);

        // Painel para os botões
        JPanel botaoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPainel.add(registerButton);
        botaoPainel.add(clearButton);
        botaoPainel.add(backButton);

        // Adicionar os painéis ao JFrame
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
}