package fileSaver.processors;

import fileSaver.processors.interfaces.IFileSaver;
import modules.freight.FreightController;

public class FileSaveFreightProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private FreightController freightController;

    public FileSaveFreightProcessor(String fileName) {
        super(fileName);
        this.freightController = new FreightController();
    }

    @Override
    public void saveFile() throws Exception {
        // TODO save freight file
    }

}
