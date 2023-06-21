package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;
import modules.harbor.HarborController;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HarborRegisterForm extends JFrame {

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

        JLabel tituloFormulario = new JLabel("Cadastro de Porto");
        tituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 20));

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

        botaoCadastrar = new JButton("Cadastrar");
        botaoLimpar = new JButton("Limpar Campos");
        botaoVoltar = new JButton("Voltar");
        mensagem = new JLabel();

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id = Integer.parseInt(campoId.getText());
                } catch (NumberFormatException exception) {
                    mensagem.setText("O ID deve ser um número inteiro.");
                    return;
                }
                if (id < 0) {
                    mensagem.setText("O ID deve ser um número positivo.");
                    return;
                }
                if (campoNome.getText().equals("")) {
                    mensagem.setText("O nome não pode ser vazio.");
                    return;
                }
                if (campoPais.getText().equals("")) {
                    mensagem.setText("O país não pode ser vazio.");
                    return;
                }
                nome = campoNome.getText();
                pais = campoPais.getText();
                harborRegister();
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoId.setText("");
                campoNome.setText("");
                campoPais.setText("");
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
