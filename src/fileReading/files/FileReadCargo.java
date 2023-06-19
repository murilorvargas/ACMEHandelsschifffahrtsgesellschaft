package fileReading.files;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReading.FileReader;
import fileReading.interfaces.IFileReader;
import modules.cargo.CargoController;
import modules.cargo.CargoService;
import shared.errors.BaseRunTimeException;

public class FileReadCargo extends FileReader implements IFileReader {

    public FileReadCargo(String fileName) {
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

                CargoController cargoController = new CargoController(new CargoService());
                if (fields.length >= 9) {
                    int id = Integer.parseInt(fields[0]);
                    int clientId = Integer.parseInt(fields[1]);
                    int originHarborId = Integer.parseInt(fields[2]);
                    int destinationHarborId = Integer.parseInt(fields[3]);
                    double weight = Double.parseDouble(fields[4]);
                    double declaredValue = Double.parseDouble(fields[5]);
                    int maxTime = Integer.parseInt(fields[6]);
                    int cargoTypeNumber = Integer.parseInt(fields[7]);
                    String priority = fields[8];
                    cargoController.onCreateCargo(id, weight, declaredValue, maxTime, priority, cargoTypeNumber,
                            originHarborId, destinationHarborId, clientId);
                }
            }
        } catch (BaseRunTimeException e) {
            e.getMessage();
        }
    }

}
