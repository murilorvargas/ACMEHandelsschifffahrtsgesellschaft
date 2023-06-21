package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;
import modules.client.ClientController;
import modules.client.entities.Client;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientRegisterForm extends JFrame {

    private JTextField campoCodigo;
    private JTextField campoNome;
    private JTextField campoEmail;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JButton botaoVoltar;
    private JLabel mensagem;

    private int codigo;
    private String nome;
    private String email;
    private ClientController clientController;

    public ClientRegisterForm() {
        super();
        clientController = new ClientController();

        JLabel tituloFormulario = new JLabel("Cadastro de Cliente");
        tituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GridLayout gridCampos = new GridLayout(3, 2);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel rotuloCodigo = new JLabel("Código:");
        campoCodigo = new JTextField();
        JLabel rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField();
        JLabel rotuloEmail = new JLabel("Email:");
        campoEmail = new JTextField();

        painelCampos.add(rotuloCodigo);
        painelCampos.add(campoCodigo);
        painelCampos.add(rotuloNome);
        painelCampos.add(campoNome);
        painelCampos.add(rotuloEmail);
        painelCampos.add(campoEmail);

        botaoCadastrar = new JButton("Cadastrar");
        botaoLimpar = new JButton("Limpar Campos");
        botaoVoltar = new JButton("Voltar");
        mensagem = new JLabel();

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    codigo = Integer.parseInt(campoCodigo.getText());
                } catch (NumberFormatException exception) {
                    mensagem.setText("Por favor, insira um número inteiro no campo código.");
                    return;
                }
                if (codigo < 0) {
                    mensagem.setText("Por favor, insira um número inteiro positivo no campo código.");
                    return;
                }
                if (campoNome.getText().equals("")) {
                    mensagem.setText("Por favor, insira um nome no campo nome.");
                    return;
                }
                if (campoEmail.getText().equals("")) {
                    mensagem.setText("Por favor, insira um email no campo email.");
                    return;
                }

                nome = campoNome.getText();
                email = campoEmail.getText();
                clientRegister();
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoCodigo.setText("");
                campoNome.setText("");
                campoEmail.setText("");
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

        this.setTitle("Cadastro de Cliente");
        this.setLayout(new BorderLayout());
        this.add(painelPrincipal, BorderLayout.NORTH);
        this.add(painelBotoes, BorderLayout.SOUTH);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ClientRegisterForm janela = new ClientRegisterForm();
    }

    private void clientRegister() {
        try {
            clientController.onCreateClient(codigo, nome, email);
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
