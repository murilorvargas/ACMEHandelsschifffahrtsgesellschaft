package fileReading.files;

import java.io.BufferedReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import fileReading.FileReader;
import fileReading.interfaces.IFileReader;
import modules.client.ClientController;
import modules.client.ClientService;
import shared.errors.BaseRunTimeException;

public class FileReadClient extends FileReader implements IFileReader {

    public FileReadClient(String fileName) {
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

                ClientController clientController = new ClientController(new ClientService());

                if (fields.length >= 3) {
                    int clientCode = Integer.parseInt(fields[0]);
                    String clientName = fields[1];
                    String clientEmail = fields[2];
                    clientController.onCreateClient(clientCode, clientName, clientEmail);
                }
            }
        } catch (BaseRunTimeException e) {
            e.getMessage();
        }
    }
}