package fileReading.files;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReading.FileReader;
import fileReading.interfaces.IFileReader;
import modules.cargoType.CargoTypeController;
import shared.errors.BaseRunTimeException;

public class FileReadCargoType extends FileReader implements IFileReader {

    public FileReadCargoType(String fileName) {
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

                if (fields.length >= 5) {
                    int number = Integer.parseInt(fields[0]);
                    String description = fields[1];
                    String type = fields[2];
                    CargoTypeController cargoTypeController = new CargoTypeController();
                    if (type.equals("PERECIVEL")) {
                        String origin = fields[3];
                        int maxValidityTime = Integer.parseInt(fields[4]);
                        cargoTypeController.onCreatePerishableCargoType(number, description, origin, maxValidityTime);
                    } else if (type.equals("DURAVEL")) {
                        String sector = fields[3];
                        String mainMaterial = fields[4];
                        double ipiPercentage = Double.parseDouble(fields[5]);
                        cargoTypeController.onCreateDurableCargoType(number, description, sector, mainMaterial,
                                ipiPercentage);
                    }
                }
            }
        } catch (BaseRunTimeException e) {
            e.getMessage();
        }

    }

}
