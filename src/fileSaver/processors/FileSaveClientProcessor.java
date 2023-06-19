package fileSaver.processors;

import fileSaver.processors.interfaces.IFileSaver;
import modules.client.ClientController;

public class FileSaveClientProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private ClientController clientController;

    public FileSaveClientProcessor(String fileName) {
        super(fileName);
        this.clientController = new ClientController();
    }

    @Override
    public void saveFile() throws Exception {
        // TODO save client file
    }

}
