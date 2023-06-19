package fileReader.processors;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReader.processors.interfaces.IFileReader;
import modules.ship.ShipController;

public class FileReadShipProcessor extends BaseFileReaderProcessor implements IFileReader {
    private ShipController shipController;

    public FileReadShipProcessor(String fileName) {
        super(fileName);
        this.shipController = new ShipController();
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

            if (fields.length >= 4) {
                String shipName = fields[0];
                double shipSpeed = Double.parseDouble(fields[1]);
                double autonomy = Double.parseDouble(fields[2]);
                double costPerMile = Double.parseDouble(fields[3]);
                this.shipController.onCreateShip(shipName, shipSpeed, autonomy, costPerMile);
            }
        }

    }
}
