package man.fota.response.dto;

import java.io.Serializable;

import man.fota.entity.Artifact;

public class ArtifactResponse implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
    private String code;
    private String type;

    private ArtifactResponse() {}
    
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
		ArtifactResponseBuilder builder = new ArtifactResponseBuilder();

		return builder
			.id(artifact.getId())
			.code(artifact.getCode())
			.type(artifact.getDiscriminatorName())
			.build();
	}
	
	public static class ArtifactResponseBuilder {
		private Long id;
	    private String code;
	    private String type;

        public ArtifactResponseBuilder id(Long id){
            this.id = id;
            return this;
        }
        
        public ArtifactResponseBuilder code(String code){
            this.code = code;
            return this;
        }
       
        public ArtifactResponseBuilder type(String type){
            this.type = type;
            return this;
        }
        
        public ArtifactResponse build(){
            ArtifactResponse response = new ArtifactResponse();
            response.setId(this.id);
            response.setCode(this.code);
            response.setType(this.type);
            return response;
        }
    }
}