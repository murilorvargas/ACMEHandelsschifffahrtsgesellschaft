package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShipRegisterForm extends JFrame {

    // Componentes
    private JTextField campoNome;
    private JTextField campoVelocidade;
    private JTextField campoAutonomia;
    private JTextField campoCustoPorMilha;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JButton botaoVoltar;
    private JLabel mensagem;

    public ShipRegisterForm() {
        super();

        // Título do formulário
        JLabel tituloFormulario = new JLabel("Cadastro de Navio");
        tituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // Painel de campos de entrada
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

        // Botões
        botaoCadastrar = new JButton("Cadastrar");
        botaoLimpar = new JButton("Limpar Campos");
        botaoVoltar = new JButton("Voltar");
        mensagem = new JLabel();

        // Tratamento de evento do botão cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar o navio
            }
        });

        // Tratamento de evento do botão limpar
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
        this.setTitle("Cadastro de Navio");
        this.setLayout(new BorderLayout());
        this.add(painelPrincipal, BorderLayout.NORTH);
        this.add(painelBotoes, BorderLayout.SOUTH);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ShipRegisterForm janela = new ShipRegisterForm();
    }
}
