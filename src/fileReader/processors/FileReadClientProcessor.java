package fileReader.processors;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReader.processors.interfaces.IFileReader;
import modules.client.ClientController;

public class FileReadClientProcessor extends BaseFileReaderProcessor implements IFileReader {
    private ClientController clientController;

    public FileReadClientProcessor(String fileName) {
        super(fileName);
        this.clientController = new ClientController();
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
                int clientCode = Integer.parseInt(fields[0]);
                String clientName = fields[1];
                String clientEmail = fields[2];
                clientController.onCreateClient(clientCode, clientName, clientEmail);
            }
        }
    }
}