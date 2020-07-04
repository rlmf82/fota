package man.fota.request.dto;

import java.io.Serializable;

import man.fota.entity.ArtifactTypeEnum;

public class RegistryRequest implements Serializable{

	private static final long serialVersionUID = 1L;

    private String vin;

    private String code;
    
	private ArtifactTypeEnum artifactType;
	
	public RegistryRequest(String vin, String code, ArtifactTypeEnum artifactType) {
		this.vin = vin;
		this.code = code;
		this.artifactType = artifactType;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArtifactTypeEnum getArtifactType() {
		return artifactType;
	}

	public void setArtifactType(ArtifactTypeEnum artifactType) {
		this.artifactType = artifactType;
	}

	@Override
	public String toString() {
		return "RegistryRequest [vin=" + vin + ", code=" + code + ", artifactType=" + artifactType + "]";
	}
}