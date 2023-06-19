package fileReader.processors;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReader.processors.interfaces.IFileReader;
import modules.cargoType.CargoTypeController;

public class FileReadCargoTypeProcessor extends BaseFileReaderProcessor implements IFileReader {
    private CargoTypeController cargoTypeController;

    public FileReadCargoTypeProcessor(String fileName) {
        super(fileName);
        this.cargoTypeController = new CargoTypeController();
    }

    @Override
    public void readFile() throws Exception {

        ArrayList<String> linesList = new ArrayList<>();

        Path filePath = Paths.get(this.getFilePath());

        BufferedReader reader = Files.newBufferedReader(filePath, Charset.forName("UTF-8"));
        String line = reader.readLine();
        line = reader.readLine();
        while (line != null) {
            linesList.add(line);
            line = reader.readLine();
        }

        for (String singleLine : linesList) {
            String[] fields = singleLine.split(";");

            if (fields.length >= 5) {
                int number = Integer.parseInt(fields[0]);
                String description = fields[1];
                String type = fields[2];
                if (type.equals("PERECIVEL")) {
                    String origin = fields[3];
                    int maxValidityTime = Integer.parseInt(fields[4]);
                    this.cargoTypeController.onCreatePerishableCargoType(number, description, origin, maxValidityTime);
                } else if (type.equals("DURAVEL")) {
                    String sector = fields[3];
                    String mainMaterial = fields[4];
                    double ipiPercentage = Double.parseDouble(fields[5]);
                    this.cargoTypeController.onCreateDurableCargoType(number, description, sector, mainMaterial,
                            ipiPercentage);
                }
            }
        }
    }

}
