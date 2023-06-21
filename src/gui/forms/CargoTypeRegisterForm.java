package gui.forms;

import javax.swing.*;

import gui.components.RegisterMenu;
import modules.cargoType.CargoTypeController;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargoTypeRegisterForm extends JFrame {

    private JTextField campoNumero;
    private JTextField campoDescricao;
    private JTextField campoOrigem;
    private JTextField campoValidadeMaxima;
    private JTextField campoSetor;
    private JTextField campoMaterial;
    private JTextField campoPorcentagemIPI;
    private JButton botaoPerecivel;
    private JButton botaoDuravel;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JButton botaoVoltar;
    private JLabel mensagem;

    private int numero;
    private String descricao;
    private String origem;
    private int validadeMaxima;
    private String setor;
    private String material;
    private double porcentagemIPI;
    private boolean perecivel = false;
    private boolean duravel = false;
    private CargoTypeController cargoTypeController;

    public CargoTypeRegisterForm() {
        super();
        cargoTypeController = new CargoTypeController();

        JLabel tituloFormulario = new JLabel("Cadastro de Tipo de Carga");
        tituloFormulario.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GridLayout gridCampos = new GridLayout(4, 2);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel rotuloNumero = new JLabel("Número:");
        campoNumero = new JTextField();
        JLabel rotuloDescricao = new JLabel("Descrição:");
        campoDescricao = new JTextField();
        JLabel rotuloOrigem = new JLabel("Origem:");
        campoOrigem = new JTextField();
        JLabel rotuloValidadeMaxima = new JLabel("Validade Máxima:");
        campoValidadeMaxima = new JTextField();
        JLabel rotuloSetor = new JLabel("Setor:");
        campoSetor = new JTextField();
        JLabel rotuloMaterial = new JLabel("Material:");
        campoMaterial = new JTextField();
        JLabel rotuloPorcentagemIPI = new JLabel("Porcentagem IPI:");
        campoPorcentagemIPI = new JTextField();

        painelCampos.add(rotuloNumero);
        painelCampos.add(campoNumero);
        painelCampos.add(rotuloDescricao);
        painelCampos.add(campoDescricao);
        painelCampos.add(rotuloOrigem);
        painelCampos.add(campoOrigem);
        painelCampos.add(rotuloValidadeMaxima);
        painelCampos.add(campoValidadeMaxima);
        painelCampos.add(rotuloSetor);
        painelCampos.add(campoSetor);
        painelCampos.add(rotuloMaterial);
        painelCampos.add(campoMaterial);
        painelCampos.add(rotuloPorcentagemIPI);
        painelCampos.add(campoPorcentagemIPI);

        botaoPerecivel = new JButton("Perecivel");
        botaoDuravel = new JButton("Duravel");
        botaoCadastrar = new JButton("Cadastrar");
        botaoLimpar = new JButton("Limpar Campos");
        botaoVoltar = new JButton("Voltar");
        mensagem = new JLabel();

        botaoPerecivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNumero.setEnabled(true);
                campoDescricao.setEnabled(true);

                campoOrigem.setEnabled(true);
                campoOrigem.setVisible(true);
                rotuloOrigem.setVisible(true);

                campoValidadeMaxima.setEnabled(true);
                campoValidadeMaxima.setVisible(true);
                rotuloValidadeMaxima.setVisible(true);

                campoSetor.setEnabled(false);
                campoSetor.setVisible(false);
                rotuloSetor.setVisible(false);

                campoMaterial.setEnabled(false);
                campoMaterial.setVisible(false);
                rotuloMaterial.setVisible(false);

                campoPorcentagemIPI.setEnabled(false);
                campoPorcentagemIPI.setVisible(false);
                rotuloPorcentagemIPI.setVisible(false);

                mensagem.setText("Perecível selecionado. Preencha os campos obrigatórios.");
                perecivel = true;
                duravel = false;

            }
        });

        botaoDuravel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNumero.setEnabled(true);
                campoDescricao.setEnabled(true);

                campoSetor.setEnabled(true);
                campoSetor.setVisible(true);
                rotuloSetor.setVisible(true);

                campoMaterial.setEnabled(true);
                campoMaterial.setVisible(true);
                rotuloMaterial.setVisible(true);

                campoPorcentagemIPI.setEnabled(true);
                campoPorcentagemIPI.setVisible(true);
                rotuloPorcentagemIPI.setVisible(true);

                campoOrigem.setEnabled(false);
                campoOrigem.setVisible(false);
                rotuloOrigem.setVisible(false);

                campoValidadeMaxima.setEnabled(false);
                campoValidadeMaxima.setVisible(false);
                rotuloValidadeMaxima.setVisible(false);

                campoPorcentagemIPI.setEnabled(false);
                campoPorcentagemIPI.setVisible(false);
                rotuloPorcentagemIPI.setVisible(false);

                mensagem.setText("Duravel selecionado. Preencha os campos obrigatórios.");
                duravel = true;
                perecivel = false;

            }
        });

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!perecivel && !duravel) {
                    mensagem.setText("Selecione um tipo de carga.");
                    return;
                }

                if (perecivel) {
                    if (campoNumero.getText().equals("") || campoDescricao.getText().equals("")
                            || campoOrigem.getText().equals("") || campoValidadeMaxima.getText().equals("")) {
                        mensagem.setText("Preencha todos os campos obrigatórios.");
                        return;
                    }
                    try {
                        numero = Integer.parseInt(campoNumero.getText());
                    } catch (NumberFormatException ex) {
                        mensagem.setText("Número inválido.");
                        return;
                    }
                    try {
                        validadeMaxima = Integer.parseInt(campoValidadeMaxima.getText());
                    } catch (NumberFormatException ex) {
                        mensagem.setText("Validade máxima inválida.");
                        return;
                    }
                    descricao = campoDescricao.getText();
                    origem = campoOrigem.getText();
                    perishableCargoRegister();

                }
                if (duravel) {
                    if (campoNumero.getText().equals("") || campoDescricao.getText().equals("")
                            || campoSetor.getText().equals("") || campoMaterial.getText().equals("")
                            || campoPorcentagemIPI.getText().equals("")) {
                        mensagem.setText("Preencha todos os campos obrigatórios.");
                        return;
                    }
                    try {
                        numero = Integer.parseInt(campoNumero.getText());
                    } catch (NumberFormatException ex) {
                        mensagem.setText("Número inválido.");
                        return;
                    }
                    try {
                        porcentagemIPI = Double.parseDouble(campoPorcentagemIPI.getText());
                    } catch (NumberFormatException ex) {
                        mensagem.setText("Porcentagem IPI inválida.");
                        return;
                    }
                    descricao = campoDescricao.getText();
                    setor = campoSetor.getText();
                    material = campoMaterial.getText();
                    durableCargoRegister();

                }

            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoNumero.setText("");
                campoDescricao.setText("");
                campoOrigem.setText("");
                campoValidadeMaxima.setText("");
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterMenu();
                setVisible(false);
            }
        });

        JPanel painelBotoesSelecao = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoesSelecao.add(botaoPerecivel);
        painelBotoesSelecao.add(botaoDuravel);

        JPanel painelPrincipal = new JPanel(new GridLayout(4, 1));
        painelPrincipal.add(tituloFormulario);
        painelPrincipal.add(painelBotoesSelecao);
        painelPrincipal.add(painelCampos);
        painelPrincipal.add(mensagem);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoVoltar);

        this.setTitle("Cadastro de Tipo de Carga");
        this.setLayout(new BorderLayout());
        this.add(painelPrincipal, BorderLayout.NORTH);
        this.add(painelBotoes, BorderLayout.SOUTH);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        CargoTypeRegisterForm janela = new CargoTypeRegisterForm();
    }

    private void perishableCargoRegister() {
        try {
            cargoTypeController.onCreatePerishableCargoType(numero, descricao, origem,
                    validadeMaxima);
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

    private void durableCargoRegister() {
        try {
            cargoTypeController.onCreateDurableCargoType(numero, descricao, setor, material, porcentagemIPI);
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
