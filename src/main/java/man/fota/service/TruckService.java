package man.fota.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import man.fota.exception.TruckNotFound;
import man.fota.request.dto.RegistryRequest;
import man.fota.response.dto.ArtifactResponse;
import man.fota.response.dto.TruckResponse;
import man.fota.util.ArtifactMode;

public interface TruckService {

	public void saveRegistries(List<RegistryRequest> registries);

	public List<TruckResponse> getAll();
	
	public Page<TruckResponse> getTrucksByArtifact(String code, ArtifactMode mode, PageRequest page);
	
	public TruckResponse getByVIN(String vin) throws TruckNotFound;
	
	public Set<ArtifactResponse> getArtifactsByVIN(String vin, ArtifactMode mode) throws TruckNotFound ;
}