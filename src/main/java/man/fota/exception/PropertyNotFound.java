package man.fota.exception;

public class PropertyNotFound extends BusinessException{

	private static final long serialVersionUID = 1L;

	public PropertyNotFound(String propertyName) {
		super("Property not found: " + propertyName);
	}
	
}
