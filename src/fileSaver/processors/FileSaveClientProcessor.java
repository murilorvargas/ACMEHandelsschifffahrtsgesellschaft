package fileSaver.processors;

import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import fileSaver.processors.interfaces.IFileSaver;
import modules.client.ClientController;
import modules.client.entities.interfaces.IClientReadable;

public class FileSaveClientProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private ClientController clientController;
    private ObjectMapper objectMapper;
    private FileWriter fileWriter;

    public FileSaveClientProcessor(String fileName) throws Exception {
        super(fileName);
        this.clientController = new ClientController();
        this.objectMapper = new ObjectMapper();
        this.fileWriter = new FileWriter(getFilePath());
    }

    @Override
    public void saveFile() throws Exception {
        List<IClientReadable> clients = this.clientController.onFindAllClients();

        fileWriter.write("[\n");

        for (int i = 0; i < clients.size(); i++) {
            IClientReadable client = clients.get(i);
            String clientJson = objectMapper.writeValueAsString(client);
            fileWriter.write(clientJson);

            if (i < clients.size() - 1) {
                fileWriter.write(",\n");
            }
        }

        fileWriter.write("\n]");

        fileWriter.close();

    }

}
