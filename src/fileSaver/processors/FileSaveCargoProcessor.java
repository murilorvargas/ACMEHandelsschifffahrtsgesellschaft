package fileSaver.processors;

import fileSaver.processors.interfaces.IFileSaver;
import modules.cargo.CargoController;

public class FileSaveCargoProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private CargoController cargoController;

    public FileSaveCargoProcessor(String fileName) {
        super(fileName);
        this.cargoController = new CargoController();
    }

    @Override
    public void saveFile() throws Exception {
        // TODO save cargo file
    }

}
