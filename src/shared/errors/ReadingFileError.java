package shared.errors;

public class ReadingFileError extends BaseRunTimeException {

    public ReadingFileError() {
        super("Erro durante a leitura do arquivo",
                "Error while reading the file",
                "Error while reading file", "HUSM0022");
    }

}