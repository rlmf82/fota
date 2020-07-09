package man.fota.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import man.fota.response.dto.TruckResponse;
import man.fota.util.ArtifactMode;

public interface TruckCustomizedRepository{

	public Page<TruckResponse> findByArtifact(String code, ArtifactMode mode, PageRequest page);
	
}