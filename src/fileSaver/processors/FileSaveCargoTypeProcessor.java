package fileSaver.processors;

import fileSaver.processors.interfaces.IFileSaver;
import modules.cargoType.CargoTypeController;

public class FileSaveCargoTypeProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private CargoTypeController cargoTypeController;

    public FileSaveCargoTypeProcessor(String fileName) {
        super(fileName);
        this.cargoTypeController = new CargoTypeController();
    }

    @Override
    public void saveFile() throws Exception {
        // TODO save cargo type file
    }

}
