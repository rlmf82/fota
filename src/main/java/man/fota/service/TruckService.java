package man.fota.service;

import java.util.List;
import java.util.Set;

import man.fota.exception.TruckNotFound;
import man.fota.request.dto.RegistryRequest;
import man.fota.response.dto.ArtifactResponse;
import man.fota.response.dto.TruckResponse;
import man.fota.util.ArtifactMode;

public interface TruckService {

	public void saveRegistries(List<RegistryRequest> registries);

	public List<TruckResponse> getAll();
	
	public List<TruckResponse> getTrucksByArtifact(String code);
	
	public TruckResponse getByVIN(String vin) throws TruckNotFound;
	
	public Set<ArtifactResponse> getArtifactsByVIN(String vin, ArtifactMode mode) throws TruckNotFound ;
}