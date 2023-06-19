package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {

    // Componentes principais
    private JTextField nomeField;
    private JTextField velocidadeField;
    private JTextField autonomiaField;
    private JTextField custoPorMilhaBasicoField;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JButton botaoSair;
    private JLabel mensagem;

    // Variaveis auxiliares
    private boolean cadastrou = false;
    private String nome;
    private int velocidade;
    private double autonomia;
    private double custoPorMilhaBasico;

    public Interface() {
        super();
        Catalogo catalogo = new Catalogo();

        JLabel formTitle = new JLabel("Cadastre um novo navio");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        GridLayout gridCampos = new GridLayout(4, 4);
        JPanel painelCampos = new JPanel(gridCampos);
        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField();
        JLabel velocidadeLabel = new JLabel("Velocidade:");
        velocidadeField = new JTextField();
        JLabel autonomiaLabel = new JLabel("Autonomia:");
        autonomiaField = new JTextField();
        JLabel custoPorMilhaBasicoLabel = new JLabel("Custo por milha básico:");
        custoPorMilhaBasicoField = new JTextField();
        painelCampos.add(nomeLabel);
        painelCampos.add(nomeField);
        painelCampos.add(velocidadeLabel);
        painelCampos.add(velocidadeField);
        painelCampos.add(autonomiaLabel);
        painelCampos.add(autonomiaField);
        painelCampos.add(custoPorMilhaBasicoLabel);
        painelCampos.add(custoPorMilhaBasicoField);

        botaoCadastrar = new JButton("Cadastrar");
        botaoLimpar = new JButton("Limpar Campos");
        botaoSair = new JButton("Sair");
        mensagem = new JLabel();

        // Tratamento de evento do botao cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    nome = nomeField.getText();
                } catch (NumberFormatException ex) {
                    mensagem.setForeground(Color.RED);
                    mensagem.setText("Erro ao cadastrar navio: Nome inválido");
                    return;
                }

                try {
                    velocidade = Integer.parseInt(velocidadeField.getText());
                } catch (NumberFormatException ex) {
                    mensagem.setForeground(Color.RED);
                    mensagem.setText("Erro ao cadastrar navio: Velocidade inválida");
                    return;
                }

                try {
                    autonomia = Double.parseDouble(autonomiaField.getText());
                } catch (NumberFormatException ex) {
                    mensagem.setForeground(Color.RED);
                    mensagem.setText("Erro ao cadastrar navio: Autonomia inválida");
                    return;
                }

                try {
                    custoPorMilhaBasico = Double.parseDouble(custoPorMilhaBasicoField.getText());
                } catch (NumberFormatException ex) {
                    mensagem.setForeground(Color.RED);
                    mensagem.setText("Erro ao cadastrar navio: Custo por milha básico inválido");
                    return;
                }

            
            }
        });

        // Tratamento de evento do botao limpar
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                autonomiaField.setText("");
                velocidadeField.setText("");
                custoPorMilhaBasicoField.setText("");
                mensagem.setText("");
            }
        });

        // Tratamento de evento do botao sair
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        GridLayout grid = new GridLayout(4, 4);
        JPanel painel = new JPanel(grid);
        painel.add(formTitle);
        painel.add(painelCampos);
        FlowLayout botaoLayout = new FlowLayout(FlowLayout.LEFT);
        JPanel botaoPainel = new JPanel(botaoLayout);
        botaoPainel.add(botaoCadastrar);
        botaoPainel.add(botaoLimpar);
        botaoPainel.add(botaoSair);
        painel.add(botaoPainel);
        painel.add(mensagem);

        this.setTitle("Cadastro de Navios");
        this.add(painel);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Interface window = new Interface();
    }
}

