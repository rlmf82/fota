package man.fota.request.dto;

import java.io.Serializable;

import man.fota.entity.ArtifactTypeEnum;

public abstract class ArtifactRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String code;
	
	private ArtifactTypeEnum type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArtifactTypeEnum getType() {
		return type;
	}

	public void setType(ArtifactTypeEnum type) {
		this.type = type;
	}
}