package input;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;


public class InputReader {
    LinkedList list = new LinkedList<>();
    String aux[];


    public void cargo(){
        
        Path path1 = Paths.get("input/CARGAS.CSV");
        lista.clear();

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-8"))) {// Charset.defaultCharset())
            String line = reader.readLine();
            while (line != null) {
                aux = line.split(";");
                if(lista.size()==0) {
                    aux[0] = aux[0].substring(1);
                    System.out.println(aux[0]);
                }
                CargoController cargo = new CargoController();
                cargo.onCreateCargo(aux[0], aux[4], aux[5], aux[6], aux[8], aux[7], aux[2], aux[3], aux[1]);
                lista.add(cargo);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
        System.out.println("Cargas:" + lista);
    }

    public void clients(){
        
        Path path1 = Paths.get("input/CLIENTES.CSV");
        lista.clear();

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-8"))) {// Charset.defaultCharset())
            String line = reader.readLine();
            while (line != null) {
                aux = line.split(";");
                if(lista.size()==0) {
                    aux[0] = aux[0].substring(1);
                    System.out.println(aux[0]);
                }
                ClientController client = new ClientController();
                client.onCreateClient(aux[0], aux[1], aux[2]);
                lista.add(client);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
        System.out.println("Clientes:" + lista);
    }

    public void harborDistance(){
        
        Path path1 = Paths.get("input/DISTANCIAS.CSV");
        lista.clear();

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-8"))) {// Charset.defaultCharset())
            String line = reader.readLine();
            while (line != null) {
                aux = line.split(";");
                if(lista.size()==0) {
                    aux[0] = aux[0].substring(1);
                    System.out.println(aux[0]);
                }
                HarborDistanceController distance = new HarborDistanceController();
                distance.onCreateHarborDistance(aux[2], aux[0], aux[1]);
                lista.add(distance);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
        System.out.println("Distâncias:" + lista);
    }

    public void ship(){
        
        Path path1 = Paths.get("input/NAVIOS.CSV");
        lista.clear();

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-8"))) {// Charset.defaultCharset())
            String line = reader.readLine();
            while (line != null) {
                aux = line.split(";");
                if(lista.size()==0) {
                    aux[0] = aux[0].substring(1);
                    System.out.println(aux[0]);
                }
                ShipController ship = new ShipController();
                ship.onCreateShip(aux[0], aux[1], aux[2], aux[3]);
                lista.add(ship);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
        System.out.println("Navios:" + lista);
    }

    public void harbor(){
        
        Path path1 = Paths.get("input/PORTOS.CSV");
        lista.clear();

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-8"))) {// Charset.defaultCharset())
            String line = reader.readLine();
            while (line != null) {
                aux = line.split(";");
                if(lista.size()==0) {
                    aux[0] = aux[0].substring(1);
                    System.out.println(aux[0]);
                }
                HarborController harbor = new HarborController();
                harbor.onCrateHarbor(aux[0], aux[1], aux[2]);
                lista.add(ship);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
        System.out.println("Portos:" + lista);
    }

    public void cargoType(){
        
        Path path1 = Paths.get("input/TIPOSCARGAS.CSV");
        lista.clear();

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.forName("UTF-8"))) {// Charset.defaultCharset())
            String line = reader.readLine();
            while (line != null) {
                aux = line.split(";");
                if(lista.size()==0) {
                    aux[0] = aux[0].substring(1);
                    System.out.println(aux[0]);
                }
                CargoTypeController type = new CargoTypeController();
                type.onCreatePerishableCargoType(aux[0], aux[1], aux[2], aux[3]);
                lista.add(type);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
        System.out.println("Tipos de carga:" + lista);
    }

    public LinkedList getList() {
        return list;
    }
}
