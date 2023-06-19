package fileReader.processors;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReader.processors.interfaces.IFileReader;
import modules.harbor.HarborController;

public class FileReadHarborProcessor extends BaseFileReaderProcessor implements IFileReader {
    private HarborController harborController;

    public FileReadHarborProcessor(String fileName) {
        super(fileName);
        this.harborController = new HarborController();
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

            if (fields.length >= 3) {
                int harborId = Integer.parseInt(fields[0]);
                String harborName = fields[1];
                String harborCountry = fields[2];
                this.harborController.onCreateHarbor(harborId, harborName, harborCountry);
            }

        }

    }
}
