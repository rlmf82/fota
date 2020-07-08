package man.fota.service;

import java.util.List;

import man.fota.response.dto.ArtifactResponse;

public interface ArtifactService {

	public ArtifactResponse findByCode(String code);
	
	public List<ArtifactResponse> findAll();

}