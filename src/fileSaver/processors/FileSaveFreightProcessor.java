package fileSaver.processors;

import java.io.FileWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import fileSaver.processors.interfaces.IFileSaver;
import modules.freight.FreightController;
import modules.freight.entities.interfaces.IFreightReadable;

public class FileSaveFreightProcessor extends BaseFileSaverProcessor implements IFileSaver {

    private FreightController freightController;
    private ObjectMapper objectMapper;
    private FileWriter fileWriter;

    public FileSaveFreightProcessor(String fileName) throws Exception {
        super(fileName);
        this.freightController = new FreightController();
        this.objectMapper = new ObjectMapper();
        this.fileWriter = new FileWriter(getFilePath());
    }

    @Override
    public void saveFile() throws Exception {
        List<IFreightReadable> freights = this.freightController.onFindAll();
        fileWriter.write("[\n");

        for (int i = 0; i < freights.size(); i++) {
            IFreightReadable freight = freights.get(i);
            String freightJson = objectMapper.writeValueAsString(freight);
            fileWriter.write(freightJson);

            if (i < freights.size() - 1) {
                fileWriter.write(",\n");
            }
        }

        fileWriter.write("\n]");

        fileWriter.close();
    }

}
