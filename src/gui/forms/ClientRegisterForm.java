package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientRegisterForm extends JFrame {

    // Componentes
    private JTextField campoCodigo;
    private JTextField campoNome;
    private JTextField campoEmail;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JButton botaoVoltar;
    private JLabel mensagem;

    public ClientRegisterForm() {
        super();

        // Título do formulário
        JLabel tituloFormulario = new JLabel("Cadastro de Cliente");
        tituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // Painel de campos de entrada
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

        // Botões
        botaoCadastrar = new JButton("Cadastrar");
        botaoLimpar = new JButton("Limpar Campos");
        botaoVoltar = new JButton("Voltar");
        mensagem = new JLabel();

        // Tratamento de evento do botão cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar o cliente
            }
        });

        // Tratamento de evento do botão limpar
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para limpar os campos
            }
        });

        // Tratamento de evento do botão voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMenu();
                setVisible(false);
            }
        });

        // Painel principal
        JPanel painelPrincipal = new JPanel(new GridLayout(2, 1));
        painelPrincipal.add(tituloFormulario);
        painelPrincipal.add(painelCampos);

        // Painel para os botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoVoltar);

        // Adicionar os painéis ao JFrame
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
}
