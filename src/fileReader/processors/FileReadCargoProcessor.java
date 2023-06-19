package fileReader.processors;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReader.processors.interfaces.IFileReader;
import modules.cargo.CargoController;

public class FileReadCargoProcessor extends BaseFileReaderProcessor implements IFileReader {
    private CargoController cargoController;

    public FileReadCargoProcessor(String fileName) {
        super(fileName);
        this.cargoController = new CargoController();
    }

    @Override
    public void readFile() throws Exception {
        ArrayList<String> linesList = new ArrayList<>();

        Path filePath = Paths.get(getFilePath());

        BufferedReader reader = Files.newBufferedReader(filePath, Charset.forName("UTF-8"));
        String line = reader.readLine();
        line = reader.readLine();
        while (line != null) {
            linesList.add(line);
            line = reader.readLine();
        }

        for (String singleLine : linesList) {
            String[] fields = singleLine.split(";");

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
                this.cargoController.onCreateCargo(id, weight, declaredValue, maxTime, priority, cargoTypeNumber,
                        originHarborId, destinationHarborId, clientId);
            }
        }
    }

}
