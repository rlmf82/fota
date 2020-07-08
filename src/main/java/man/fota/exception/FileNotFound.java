package man.fota.exception;

public class FileNotFound extends BusinessException{

	private static final long serialVersionUID = 1L;

	public FileNotFound() {
		super("File not found");
	}
	
}
