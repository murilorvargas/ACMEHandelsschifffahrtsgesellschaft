package fileSaver.processors;

import fileSaver.processors.interfaces.IFileSaver;
import modules.harbor.entities.Harbor;
import modules.harborDistance.HarborDistanceController;
import modules.harborDistance.entities.HarborDistance;

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
