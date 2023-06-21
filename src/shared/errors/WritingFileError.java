package shared.errors;

public class WritingFileError extends BaseRunTimeException {

    public WritingFileError() {
        super("Erro ao escrever o arquivo", "Ocorreu um erro ao escrever o arquivo", "Error while writing file",
                "HUSM0031");
    }

}
