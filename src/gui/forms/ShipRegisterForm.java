package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;
import modules.ship.ShipController;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShipRegisterForm extends JFrame {

    private JTextField campoNome;
    private JTextField campoVelocidade;
    private JTextField campoAutonomia;
    private JTextField campoCustoPorMilha;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JButton botaoVoltar;
    private JLabel mensagem;

    private String nome;
    private double velocidade;
    private double autonomia;
    private double custoPorMilha;
    private ShipController shipController;

    public ShipRegisterForm() {
        super();
        shipController = new ShipController();

        JLabel tituloFormulario = new JLabel("Cadastro de Navio");
        tituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GridLayout gridCampos = new GridLayout(4, 2);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField();
        JLabel rotuloVelocidade = new JLabel("Velocidade:");
        campoVelocidade = new JTextField();
        JLabel rotuloAutonomia = new JLabel("Autonomia:");
        campoAutonomia = new JTextField();
        JLabel rotuloCustoPorMilha = new JLabel("Custo por Milha:");
        campoCustoPorMilha = new JTextField();

        painelCampos.add(rotuloNome);
        painelCampos.add(campoNome);
        painelCampos.add(rotuloVelocidade);
        painelCampos.add(campoVelocidade);
        painelCampos.add(rotuloAutonomia);
        painelCampos.add(campoAutonomia);
        painelCampos.add(rotuloCustoPorMilha);
        painelCampos.add(campoCustoPorMilha);

        botaoCadastrar = new JButton("Cadastrar");
        botaoLimpar = new JButton("Limpar Campos");
        botaoVoltar = new JButton("Voltar");
        mensagem = new JLabel();

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    velocidade = Double.parseDouble(campoVelocidade.getText());
                } catch (NumberFormatException exception) {
                    mensagem.setText("Velocidade deve ser um número.");
                    return;
                }
                if (velocidade < 0) {
                    mensagem.setText("Velocidade deve ser um número positivo.");
                    return;
                }
                try {
                    autonomia = Double.parseDouble(campoAutonomia.getText());
                } catch (NumberFormatException exception) {
                    mensagem.setText("Autonomia deve ser um número.");
                    return;
                }
                if (autonomia < 0) {
                    mensagem.setText("Autonomia deve ser um número positivo.");
                    return;
                }
                try {
                    custoPorMilha = Double.parseDouble(campoCustoPorMilha.getText());
                } catch (NumberFormatException exception) {
                    mensagem.setText("Custo por Milha deve ser um número.");
                    return;
                }
                if (custoPorMilha < 0) {
                    mensagem.setText("Custo por Milha deve ser um número positivo.");
                    return;
                }
                if (campoNome.getText().equals("")) {
                    mensagem.setText("Nome não pode ser vazio.");
                    return;
                }
                nome = campoNome.getText();
                shipRegister();
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNome.setText("");
                campoVelocidade.setText("");
                campoAutonomia.setText("");
                campoCustoPorMilha.setText("");
                mensagem.setText("");
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMenu();
                setVisible(false);
            }
        });

        JPanel painelPrincipal = new JPanel(new GridLayout(3, 1));
        painelPrincipal.add(tituloFormulario);
        painelPrincipal.add(painelCampos);
        painelPrincipal.add(mensagem);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoVoltar);

        this.setTitle("Cadastro de Navio");
        this.setLayout(new BorderLayout());
        this.add(painelPrincipal, BorderLayout.NORTH);
        this.add(painelBotoes, BorderLayout.SOUTH);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ShipRegisterForm();
    }

    private void shipRegister() {
        try {
            shipController.onCreateShip(nome, velocidade, autonomia, custoPorMilha);
        } catch (BaseRunTimeException e) {
            mensagem.setText(e.getTranslation());
            return;
        } catch (Exception e) {
            mensagem.setText("Erro ao ler o arquivo.");
            return;
        }
        new RegisterMenu();
        setVisible(false);
    }
}
