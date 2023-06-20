package fileSaver.processors;

import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import fileSaver.processors.interfaces.IFileSaver;
import modules.cargo.CargoController;
import modules.cargo.entities.interfaces.ICargoReadable;

public class FileSaveCargoProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private CargoController cargoController;
    private ObjectMapper objectMapper;
    private FileWriter fileWriter;

    public FileSaveCargoProcessor(String fileName) throws Exception {
        super(fileName);
        this.cargoController = new CargoController();
        this.objectMapper = new ObjectMapper();
        this.fileWriter = new FileWriter(getFilePath());
    }

    @Override
    public void saveFile() throws Exception {
        List<ICargoReadable> cargos = this.cargoController.onFindAllCargos();

        fileWriter.write("[\n");

        for (int i = 0; i < cargos.size(); i++) {
            ICargoReadable cargo = cargos.get(i);
            String cargoJson = objectMapper.writeValueAsString(cargo);
            fileWriter.write(cargoJson);

            if (i < cargos.size() - 1) {
                fileWriter.write(",\n");
            }
        }

        fileWriter.write("\n]");

        fileWriter.close();

    }

}
