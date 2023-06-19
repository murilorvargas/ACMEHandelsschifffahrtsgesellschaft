package fileReader.processors;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReader.processors.interfaces.IFileReader;
import modules.harborDistance.HarborDistanceController;

public class FileReadHarborDistanceProcessor extends BaseFileReaderProcessor implements IFileReader {
    private HarborDistanceController harborDistanceController;

    public FileReadHarborDistanceProcessor(String fileName) {
        super(fileName);
        this.harborDistanceController = new HarborDistanceController();
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

            if (fields.length >= 3) {
                int harborOriginId = Integer.parseInt(fields[0]);
                int harborDestinyId = Integer.parseInt(fields[1]);
                double distance = Double.parseDouble(fields[2]);

                this.harborDistanceController.onCreateHarborDistance(distance, harborOriginId, harborDestinyId);
            }
        }
    }
}
