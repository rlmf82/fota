package man.fota.response.dto;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import man.fota.entity.Feature;

public class FeatureResponse implements Serializable{

	private static final long serialVersionUID = 1L;

    private Set<ArtifactResponse> requiredArtifact;
    
    private Set<ArtifactResponse> forbiddenArtifact;
	
	public Set<ArtifactResponse> getRequiredArtifact() {
		return requiredArtifact;
	}

	public void setRequiredArtifact(Set<ArtifactResponse> requiredArtifact) {
		this.requiredArtifact = requiredArtifact;
	}

	public Set<ArtifactResponse> getForbiddenArtifact() {
		return forbiddenArtifact;
	}

	public void setForbiddenArtifact(Set<ArtifactResponse> forbiddenArtifact) {
		this.forbiddenArtifact = forbiddenArtifact;
	}

	public static FeatureResponse transform(Feature feature) {
		Set<ArtifactResponse> required = null;
		Set<ArtifactResponse> forbidden = null;
		
		FeatureResponse response = new FeatureResponse();

		if(feature.getRequiredArtifact() != null) {
			required = feature
					.getRequiredArtifact()
					.stream()
					.map(ArtifactResponse::transform)
					.collect(Collectors.toSet());
		}
		
		if(feature.getForbiddenArtifact() != null) {
			forbidden = feature
					.getForbiddenArtifact()
					.stream()
					.map(ArtifactResponse::transform)
					.collect(Collectors.toSet());
		}
		
		response.setRequiredArtifact(required);
		response.setForbiddenArtifact(forbidden);
		
		return response;
	}
}