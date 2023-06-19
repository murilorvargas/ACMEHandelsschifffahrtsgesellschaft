package fileReading.files;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReading.FileReader;
import fileReading.interfaces.IFileReader;
import modules.harbor.HarborController;
import modules.harbor.HarborService;
import shared.errors.BaseRunTimeException;

public class FileReadHarbor extends FileReader implements IFileReader {

    public FileReadHarbor(String fileName) {
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

                HarborController harborController = new HarborController(new HarborService());
                if (fields.length >= 3) {
                    int harborId = Integer.parseInt(fields[0]);
                    String harborName = fields[1];
                    String harborCountry = fields[2];
                    harborController.onCreateHarbor(harborId, harborName, harborCountry);
                }

            }
        } catch (BaseRunTimeException e) {
            e.getMessage();
        }
    }
}
