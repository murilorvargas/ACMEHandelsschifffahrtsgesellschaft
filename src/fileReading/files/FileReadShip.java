package fileReading.files;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReading.FileReader;
import fileReading.interfaces.IFileReader;
import modules.ship.ShipController;
import modules.ship.ShipService;
import shared.errors.BaseRunTimeException;

public class FileReadShip extends FileReader implements IFileReader {

    public FileReadShip(String fileName) {
        super(fileName);
    }

    @Override
    public void readFile() {
        ArrayList<String> lines = new ArrayList<>();

        Path filePath = Paths.get(getFilePath());

        try (BufferedReader reader = Files.newBufferedReader(filePath, Charset.forName("UTF-8"))) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.format("Erro na leitura do arquivo: %s", e.getMessage());
        }

        try {
            for (String line : lines) {
                String[] fields = line.split(";");

                ShipController shipController = new ShipController(new ShipService());

                if (fields.length >= 4) {
                    String shipName = fields[0];
                    double shipSpeed = Double.parseDouble(fields[1]);
                    double autonomy = Double.parseDouble(fields[2]);
                    double costPerMile = Double.parseDouble(fields[3]);
                    shipController.onCreateShip(shipName, shipSpeed, autonomy, costPerMile);
                }
            }
        } catch (BaseRunTimeException e) {
            e.getMessage();
        }
    }
}
