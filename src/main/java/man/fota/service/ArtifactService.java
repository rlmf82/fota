package man.fota.service;

import man.fota.response.dto.ArtifactResponse;

public interface ArtifactService {

	public ArtifactResponse findByCode(String code);

}