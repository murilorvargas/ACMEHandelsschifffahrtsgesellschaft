package fileReading.files;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReading.FileReader;
import fileReading.interfaces.IFileReader;
import modules.harborDistance.HarborDistanceController;
import modules.harborDistance.HarborDistanceService;
import shared.errors.BaseRunTimeException;

public class FileReadHarborDistance extends FileReader implements IFileReader {

    public FileReadHarborDistance(String fileName) {
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

                HarborDistanceController harborDistanceController = new HarborDistanceController(
                        new HarborDistanceService());
                if (fields.length >= 3) {
                    int harborOriginId = Integer.parseInt(fields[0]);
                    int harborDestinyId = Integer.parseInt(fields[1]);
                    double distance = Double.parseDouble(fields[2]);

                    harborDistanceController.onCreateHarborDistance(distance, harborOriginId, harborDestinyId);
                }
            }
        } catch (BaseRunTimeException e) {
            e.getMessage();
        }
    }
}
