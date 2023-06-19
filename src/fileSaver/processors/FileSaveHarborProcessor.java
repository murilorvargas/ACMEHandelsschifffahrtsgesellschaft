package fileSaver.processors;

import fileSaver.processors.interfaces.IFileSaver;
import modules.harbor.HarborController;
import modules.harbor.entities.Harbor;

public class FileSaveHarborProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private HarborController harborController;

    public FileSaveHarborProcessor(String fileName) {
        super(fileName);
        this.harborController = new HarborController();
    }

    @Override
    public void saveFile() throws Exception {
        // TODO save harbor file
    }

}
