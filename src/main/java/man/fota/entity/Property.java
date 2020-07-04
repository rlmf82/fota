package man.fota.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Property implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Enumerated(EnumType.STRING)
    private PropertyKeyEnum key;

    @Column(name = "value")
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
}