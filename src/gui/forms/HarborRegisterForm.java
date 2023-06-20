package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;
import modules.harbor.HarborController;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HarborRegisterForm extends JFrame {

    // Componentes
    private JTextField campoId;
    private JTextField campoNome;
    private JTextField campoPais;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JButton botaoVoltar;
    private JLabel mensagem;

    private int id;
    private String nome;
    private String pais;
    private HarborController harborController;

    public HarborRegisterForm() {
        super();
        harborController = new HarborController();

        // Título do formulário
        JLabel tituloFormulario = new JLabel("Cadastro de Porto");
        tituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // Painel de campos de entrada
        GridLayout gridCampos = new GridLayout(3, 2);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel rotuloId = new JLabel("ID:");
        campoId = new JTextField();
        JLabel rotuloNome = new JLabel("Nome:");
        campoNome = new JTextField();
        JLabel rotuloPais = new JLabel("País:");
        campoPais = new JTextField();

        painelCampos.add(rotuloId);
        painelCampos.add(campoId);
        painelCampos.add(rotuloNome);
        painelCampos.add(campoNome);
        painelCampos.add(rotuloPais);
        painelCampos.add(campoPais);

        // Botões
        botaoCadastrar = new JButton("Cadastrar");
        botaoLimpar = new JButton("Limpar Campos");
        botaoVoltar = new JButton("Voltar");
        mensagem = new JLabel();

        // Tratamento de evento do botão cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                id = Integer.parseInt(campoId.getText());
                nome = campoNome.getText();
                pais = campoPais.getText();
                harborRegister();
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
        this.setTitle("Cadastro de Porto");
        this.setLayout(new BorderLayout());
        this.add(painelPrincipal, BorderLayout.NORTH);
        this.add(painelBotoes, BorderLayout.SOUTH);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        HarborRegisterForm janela = new HarborRegisterForm();
    }

    private void harborRegister() {
        try {
            harborController.onCreateHarbor(id, nome, pais);
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
