package application;

import fileReader.FileReader;
import fileSaver.FileSaver;

public class App {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader();
        fileReader.readFile("EXEMPLO-PORTOS", "harbor");
        fileReader.readFile("EXEMPLO-DISTANCIAS", "harborDistance");
        fileReader.readFile("EXEMPLO-NAVIOS", "ship");
        fileReader.readFile("EXEMPLO-CLIENTES", "client");
        fileReader.readFile("EXEMPLO-TIPOSCARGAS", "cargoType");
        fileReader.readFile("EXEMPLO-CARGAS", "cargo"); // TODO corrigir a leitura desse arquivo

        FileSaver fileSaver = new FileSaver();
        fileSaver.saveFile("harbor", "harbor");
        fileSaver.saveFile("harborDistance", "harborDistance");
        fileSaver.saveFile("ship", "ship");
        fileSaver.saveFile("client", "client");
        fileSaver.saveFile("cargo", "cargo");
        fileSaver.saveFile("freight", "freight"); // TODO corrigir o salvamento de dados dos fretes
        fileSaver.saveFile("cargoType", "cargoType"); // TODO corrigir o salvamento de dados dos tipos de carga
    }
}
