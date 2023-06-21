package gui.components;

import javax.swing.*;

import gui.MainApplication;
import modules.cargo.CargoController;
import modules.cargo.entities.interfaces.ICargoReadable;
import modules.client.ClientController;
import modules.client.entities.interfaces.IClientReadable;
import modules.harbor.HarborController;
import modules.harbor.entities.interfaces.IHarborReadable;
import modules.cargoType.CargoTypeController;
import modules.cargoType.entities.DurableCargoType;
import modules.cargoType.entities.PerishableCargoType;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;
import modules.cargoType.entities.interfaces.IDurableCargoTypeReadable;
import modules.cargoType.entities.interfaces.IPerishableCargoTypeReadable;
import modules.ship.ShipController;
import modules.ship.entities.interfaces.IShipReadable;
import modules.freight.FreightController;
import modules.freight.entities.interfaces.IFreightReadable;
import shared.errors.BaseRunTimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListMenu extends JFrame {

    private JButton cargoButton;
    private JButton cargoTypeButton;
    private JButton clientButton;
    private JButton harborButton;
    private JButton shipButton;
    private JButton freightPendingButton;
    private JButton allFreightButton;
    private JButton backButton;
    private JLabel message;

    private CargoController cargoController;
    private ClientController clientController;
    private HarborController harborController;
    private CargoTypeController cargoTypeController;
    private ShipController shipController;
    private FreightController freightController;

    public ListMenu() {
        super();
        cargoController = new CargoController();
        clientController = new ClientController();
        harborController = new HarborController();
        cargoTypeController = new CargoTypeController();
        shipController = new ShipController();
        freightController = new FreightController();

        JLabel formTitle = new JLabel("Listas");
        formTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

        cargoButton = new JButton("Lista de Cargas");
        cargoTypeButton = new JButton("Lista Tipo de Cargas");
        clientButton = new JButton("Lista de Cliente");
        harborButton = new JButton("Lista de Porto");
        shipButton = new JButton("Lista de Navio");
        freightPendingButton = new JButton("Lista de Frete Pendentes");
        allFreightButton = new JButton("Lista de Todos os Fretes");
        backButton = new JButton("Voltar");
        message = new JLabel();

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

                for (ICargoReadable cargo : cargoController.onFindAllCargos()) {
                    String info = "Carga " + cargo.getId() + ": " +
                            "Peso: " + cargo.getWeight() + ", " +
                            "Tempo Máximo: " + cargo.getMaxTime() + ", " +
                            "Prioridade: " + cargo.getPriority() + ", " +
                            "Tipo de carga: " + cargo.getCargoType().getDescription()
                            + ", " +
                            "Porto de Origem: " + cargo.getOriginHarbor().getName()
                            + ", " +
                            "Porto de Destino: "
                            + cargo.getDestinationHarbor().getName()
                            + ", " +
                            "Cliente: " + cargo.getClient().getName()
                            + ", " +
                            "Status da Carga: " + cargo.getStatus() +
                            " ,";

                    if (cargo.getDestinedShip() != null) {
                        info += "Navio: " + cargo.getDestinedShip().getName() + " ;";
                    } else {
                        info += "Navio: Não Atribuido ;";
                    }

                    list.add(info);
                }
                displayTable("Lista de Cargas", list);
            }
        });

        cargoTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cargoTypeController.onFindAllCargoTypes();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao ler o arquivo.");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                for (ICargoTypeReadable cargoType : cargoTypeController.onFindAllCargoTypes()) {
                    if (cargoType instanceof IDurableCargoTypeReadable) {
                        String info = "Carga " + cargoType.getNumber() + ": " +
                                "Descrição: " + cargoType.getDescription() + ", " +
                                "Setor: "
                                + ((DurableCargoType) cargoType).getSector()
                                + ", " +
                                "Material: "
                                + ((DurableCargoType) cargoType).getMainMaterial()
                                + ", " +
                                "Porcentagem IPI: "
                                + ((DurableCargoType) cargoType).getIpiPercentage()
                                + ";  ";
                        list.add(info);
                    } else if (cargoType instanceof IPerishableCargoTypeReadable) {
                        String info = "Carga " + cargoType.getNumber()
                                + ": " +
                                "Descrição: " + cargoType.getDescription()
                                + ", " +
                                "Origem: "
                                + ((PerishableCargoType) cargoType)
                                        .getOrigin()
                                + ", " +
                                "Validade: "
                                + ((PerishableCargoType) cargoType)
                                        .getMaxValidityTime()
                                + ";  ";
                        list.add(info);
                    }
                }
                displayTable("Lista de Tipo Cargas", list);
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
                for (IClientReadable client : clientController.onFindAllClients()) {
                    String info = "Cliente " + client.getCode() + ": " +
                            "Nome: " + client.getName() + ", " +
                            "Email: " + client.getEmail() + ";  ";
                    list.add(info);
                }
                displayTable("Lista de Clientes", list);
            }
        });

        harborButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    harborController.onFindAllHarbors();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao ler o arquivo.");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                for (IHarborReadable harbor : harborController.onFindAllHarbors()) {
                    String info = "Porto " + harbor.getId() + ": " +
                            "Nome: " + harbor.getName() + ", " +
                            "País: " + harbor.getCountry() + ";  ";
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
                for (IShipReadable ship : shipController.onFindAllShips()) {
                    String info = "Navio " + ship.getId() + ": " +
                            "Nome: " + ship.getName() + ", " +
                            "Velocidade: " + ship.getSpeed() + ", " +
                            "Autonomia: " + ship.getAutonomy() + ", " +
                            "Autonomia: " + ship.getCostPerMile() + ";  ";
                    list.add(info);
                }
                displayTable("Lista de Navios", list);
            }
        });

        allFreightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    freightController.onFindAll();
                } catch (BaseRunTimeException a) {
                    message.setText(a.getTranslation());
                    return;
                } catch (Exception a) {
                    message.setText("Erro ao ler o arquivo.");
                    return;
                }
                ArrayList<String> list = new ArrayList<>();
                for (IFreightReadable freightReadable : freightController.onFindAll()) {
                    String info = "Frete " + freightReadable.getId() + ": " +
                            "Carga: " + freightReadable.getCargo().getId() + ", "
                            +
                            "Valor: " + freightReadable.getValue() + ", " +
                            "Navio: " + freightReadable.getShip().getName() + ", " +
                            "Status do Frete: " + freightReadable.getStatus() + ";  ";
                    list.add(info);
                }
                displayTable("Lista de Todos os Fretes", list);
            }
        });

        freightPendingButton.addActionListener(new ActionListener() {
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
                for (IFreightReadable freightReadable : freightController.onFindAllInProgressFreights()) {
                    String info = "Frete " + freightReadable.getId() + ": " +
                            "Carga: " + freightReadable.getCargo().getId() + ", "
                            +
                            "Valor: " + freightReadable.getValue() + ", " +
                            "Navio: " + freightReadable.getShip().getName() + ";  ";
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

        JPanel painel = new JPanel(new GridLayout(3, 1));
        painel.add(formTitle);
        painel.add(message);

        JPanel botaoPainel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoPainel.add(cargoButton);
        botaoPainel.add(cargoTypeButton);
        botaoPainel.add(clientButton);
        botaoPainel.add(harborButton);
        botaoPainel.add(shipButton);
        botaoPainel.add(freightPendingButton);
        botaoPainel.add(allFreightButton);
        botaoPainel.add(backButton);
        painel.add(botaoPainel);

        this.setTitle("Lista");
        this.add(painel);
        this.setSize(800, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ListMenu();
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
