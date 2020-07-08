package man.fota.response.dto;

import java.io.Serializable;

import man.fota.entity.Artifact;

public class ArtifactResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
    private String code;
    
    private String type;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static ArtifactResponse transform(Artifact artifact) {
		ArtifactResponse response = new ArtifactResponse();
		response.setId(artifact.getId());
		response.setCode(artifact.getCode());
		response.setType(artifact.getDiscriminatorName());
		
		return response;
	}
}