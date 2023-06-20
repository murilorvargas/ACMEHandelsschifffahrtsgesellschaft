package application;

import fileReader.FileReader;
import fileSaver.FileSaver;

public class App {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader();
        fileReader.readFile("EXEMPLO-PORTOS", "harbor");

        FileSaver fileSaver = new FileSaver();
        fileSaver.saveFile("harbor", "harbor");
    }
}
