package fileSaver.processors;

import fileSaver.processors.interfaces.IFileSaver;
import modules.harborDistance.HarborDistanceController;

public class FileSaveHarborDistanceProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private HarborDistanceController harborDistanceController;

    public FileSaveHarborDistanceProcessor(String fileName) {
        super(fileName);
        this.harborDistanceController = new HarborDistanceController();
    }

    @Override
    public void saveFile() throws Exception {
        // TODO save harbor distance file
    }

}
