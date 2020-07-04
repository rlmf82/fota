package man.fota.response.dto;

import java.io.Serializable;

import man.fota.entity.Property;
import man.fota.entity.PropertyKeyEnum;

public class PropertyResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private PropertyKeyEnum key;
	
	private String value;
	
	public PropertyKeyEnum getKey() {
		return key;
	}

	public void setKey(PropertyKeyEnum key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static PropertyResponse tranform(Property property) {
		PropertyResponse propertyResponse = new PropertyResponse();
		propertyResponse.setKey(property.getKey());
		propertyResponse.setValue(property.getValue());
		
		return propertyResponse;
	}
}