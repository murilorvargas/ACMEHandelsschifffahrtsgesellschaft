package fileSaver.processors;

import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import fileSaver.processors.interfaces.IFileSaver;
import modules.cargoType.CargoTypeController;
import modules.cargoType.entities.interfaces.ICargoTypeReadable;

public class FileSaveCargoTypeProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private CargoTypeController cargoTypeController;
    private ObjectMapper objectMapper;
    private FileWriter fileWriter;

    public FileSaveCargoTypeProcessor(String fileName) throws Exception {
        super(fileName);
        this.cargoTypeController = new CargoTypeController();
        this.objectMapper = new ObjectMapper();
        this.fileWriter = new FileWriter(getFilePath());
    }

    @Override
    public void saveFile() throws Exception {
        List<ICargoTypeReadable> cargoTypes = this.cargoTypeController.onFindAllCargoTypes();

        fileWriter.write("[\n");

        for (int i = 0; i < cargoTypes.size(); i++) {
            ICargoTypeReadable cargo = cargoTypes.get(i);
            String cargoTypeJson = objectMapper.writeValueAsString(cargo);
            fileWriter.write(cargoTypeJson);

            if (i < cargoTypes.size() - 1) {
                fileWriter.write(",\n");
            }
        }

        fileWriter.write("\n]");

        fileWriter.close();

    }

}
