package man.fota.exception;

public class TruckNotFound extends BusinessException{

	private static final long serialVersionUID = 1L;

	public TruckNotFound() {
		super("Truck not found");
	}
	
}
