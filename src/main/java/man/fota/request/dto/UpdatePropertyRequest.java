package man.fota.request.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import man.fota.entity.PropertyKeyEnum;

public class UpdatePropertyRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotNull
    private PropertyKeyEnum key;

	@NotNull
	@NotBlank
    private String value;
    
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public PropertyKeyEnum getKey() {
		return key;
	}

	public void setKey(PropertyKeyEnum key) {
		this.key = key;
	}
}