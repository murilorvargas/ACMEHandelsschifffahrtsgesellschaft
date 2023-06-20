package gui.components;

import javax.swing.*;

import gui.MainApplication;
import gui.forms.CargoTypeRegisterForm;
import gui.forms.ClientRegisterForm;
import gui.forms.HarborRegisterForm;
import gui.forms.ShipRegisterForm;
import modules.cargo.CargoController;
import modules.client.ClientController;
import modules.harbor.HarborController;
import modules.cargoType.CargoTypeController;
import modules.ship.ShipController;
import modules.freight.FreightController;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListMenu extends JFrame {

    // Componentes principais
    private JButton cargoButton;
    private JButton cargoTypeButton;
    private JButton clientButton;
    private JButton harborButton;
    private JButton shipButton;
    private JButton freightButton;
    private JButton backButton;
    private JLabel message;

    private CargoController cargoController;
    private ClientController clientController;
    private HarborController harnorController;
    private CargoTypeController cargoTypeController;
    private ShipController shipController;
    private FreightController freightController;

    public ListMenu() {
        super();
        cargoController = new CargoController();
        clientController = new ClientController();
        harnorController = new HarborController();
        cargoTypeController = new CargoTypeController();
        shipController = new ShipController();
        freightController = new FreightController();

        // Título do formulário
        JLabel formTitle = new JLabel("Leitura de Arquivos");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // Botões
        cargoButton = new JButton("Lista de Cargas");
        cargoTypeButton = new JButton("Lista de Tipo de Carga");
        clientButton = new JButton("Lista de Cliente");
        harborButton = new JButton("Lista de Porto");
        shipButton = new JButton("Lista de Navio");
        freightButton = new JButton("Lista de Frete");
        backButton = new JButton("Voltar");
        message = new JLabel();

        // Tratamento de evento do botão cadastrar carga
        cargoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cargoController.onFindAllCargos();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao ler o arquivo.");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < cargoController.onFindAllCargos().size(); i++) {
                    String info = "Carga " + cargoController.onFindAllCargos().get(i).getId() + ": " +
                            "Peso: " + cargoController.onFindAllCargos().get(i).getWeight() + ", " +
                            "Tempo Máximo: " + cargoController.onFindAllCargos().get(i).getMaxTime() + ", " +
                            "Prioridade: " + cargoController.onFindAllCargos().get(i).getPriority() + ", " +
                            "Tipo de carga: " + cargoController.onFindAllCargos().get(i).getCargoType() + ", " +
                            "Porto de Origem: " + cargoController.onFindAllCargos().get(i).getOriginHarbor() + ", " +
                            "Porto de Destino: " + cargoController.onFindAllCargos().get(i).getDestinationHarbor()
                            + ", " +
                            "Cliente: " + cargoController.onFindAllCargos().get(i).getClient() + ";  ";
                    list.add(info);
                }
                displayTable("Lista de Cargas", list);
            }
        });

        cargoTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aux = "";
                // for (int i = 0; i < cargoTypeController..size(); i++) {
                // aux += "Tipo de carga " + cargoTypeController.onFindAllCargoTypes().get(i) +
                // ": " +
                // "Peso: " + cargoTypeController.onFindAllCargoTypes().get(i).getWeight() + ",
                // " +
                // "Tempo Máximo: " +
                // cargoTypeController.onFindAllCargoTypes().get(i).getMaxTime() + ", " +
                // "Prioridade: " +
                // cargoTypeController.onFindAllCargoTypes().get(i).getPriority() + ", "+
                // "Tipo de carga: " +
                // cargoTypeController.onFindAllCargoTypes().get(i).getCargoType() + ", "+
                // "Porto de Origem: " +
                // cargoTypeController.onFindAllCargoTypes().get(i).getOriginHarbor() + ", "+
                // "Porto de Destino: " +
                // cargoTypeController.onFindAllCargoTypes().get(i).getDestinationHarbor() + ",
                // "+
                // "Cliente: " + cargoTypeController.onFindAllCargoTypes().get(i).getClient() +
                // "; ";
                // }
                // message.setText("Lista de Clientes: " + "\n" + aux);
            }
        });

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clientController.onFindAllClients();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao ler o arquivo.");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < clientController.onFindAllClients().size(); i++) {
                    String info = "Cliente " + clientController.onFindAllClients().get(i).getCode() + ": " +
                            "Nome: " + clientController.onFindAllClients().get(i).getName() + ", " +
                            "Email: " + clientController.onFindAllClients().get(i).getEmail() + ";  ";
                    list.add(info);
                }
                displayTable("Lista de Clientes", list);
            }
        });

        harborButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    harnorController.onFindAllHarbors();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao ler o arquivo.");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < harnorController.onFindAllHarbors().size(); i++) {
                    String info = "Porto " + harnorController.onFindAllHarbors().get(i).getId() + ": " +
                            "Nome: " + harnorController.onFindAllHarbors().get(i).getName() + ", " +
                            "País: " + harnorController.onFindAllHarbors().get(i).getCountry() + ";  ";
                    list.add(info);
                }
                displayTable("Lista de Portos", list);
            }
        });

        shipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    shipController.onFindAllShips();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao ler o arquivo.");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < shipController.onFindAllShips().size(); i++) {
                    String info = "Navio " + (i + 1) + ": " +
                            "Nome: " + shipController.onFindAllShips().get(i).getName() + ", " +
                            "Velocidade: " + shipController.onFindAllShips().get(i).getSpeed() + ", " +
                            "Autonomia: " + shipController.onFindAllShips().get(i).getAutonomy() + ", " +
                            "Autonomia: " + shipController.onFindAllShips().get(i).getCostPerMile() + ";  ";
                    list.add(info);
                }
                displayTable("Lista de Navios", list);
            }
        });

        freightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    freightController.onFindAllInProgressFreights();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao ler o arquivo.");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < freightController.onFindAllInProgressFreights().size(); i++) {
                    String info = "Frete " + freightController.onFindAllInProgressFreights().get(i).getId() + ": " +
                            "Carga: " + freightController.onFindAllInProgressFreights().get(i).getCargo() + ", " +
                            "Valor: " + freightController.onFindAllInProgressFreights().get(i).getValue() + ", " +
                            "Navio: " + freightController.onFindAllInProgressFreights().get(i).getShip() + ";  ";
                    list.add(info);
                }
                displayTable("Lista de Fretes Pendentes", list);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                new MainApplication();
                setVisible(false);
            }
        });

        // Painel principal
        JPanel painel = new JPanel(new GridLayout(3, 1));
        painel.add(formTitle);
        painel.add(message);

        // Painel para os botões
        JPanel botaoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPainel.add(cargoButton);
        botaoPainel.add(cargoTypeButton);
        botaoPainel.add(clientButton);
        botaoPainel.add(harborButton);
        botaoPainel.add(shipButton);
        botaoPainel.add(freightButton);
        botaoPainel.add(backButton);
        painel.add(botaoPainel);

        // Configurações da janela
        this.setTitle("Main Menu");
        this.add(painel);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ListMenu window = new ListMenu();
    }

    private void displayTable(String title, ArrayList<String> data) {
        JFrame tableFrame = new JFrame(title);
        String[] columnNames = { title };
        Object[][] rowData = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            rowData[i][0] = data.get(i);
        }
        JTable table = new JTable(rowData, columnNames);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        tableFrame.getContentPane().add(scrollPane);
        tableFrame.pack();
        tableFrame.setVisible(true);
    }
}
