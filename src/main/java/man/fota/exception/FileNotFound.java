package man.fota.exception;

public class FileNotFound extends Exception{

	private static final long serialVersionUID = 1L;

	public FileNotFound() {
		super("File not found");
	}
	
}
