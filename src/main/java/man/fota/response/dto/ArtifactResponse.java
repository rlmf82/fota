package man.fota.response.dto;

import java.io.Serializable;

import man.fota.entity.Artifact;

public class ArtifactResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
    private String code;

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

	public static ArtifactResponse transform(Artifact artifact) {
		ArtifactResponse response = new ArtifactResponse();
		response.setId(artifact.getId());
		response.setCode(artifact.getCode());
		
		return response;
	}
}