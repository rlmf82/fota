package man.fota.serviceImpl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import man.fota.entity.Artifact;
import man.fota.entity.ArtifactTypeEnum;
import man.fota.entity.Feature;
import man.fota.entity.HardwareArtifact;
import man.fota.entity.SoftwareArtifact;
import man.fota.entity.Truck;
import man.fota.repository.TruckRepository;
import man.fota.request.dto.RegistryRequest;
import man.fota.response.dto.ArtifactResponse;
import man.fota.service.ArtifactService;
import man.fota.service.TruckService;

@Service
public class TruckServiceImpl implements TruckService {

	@Autowired
	private TruckRepository repository;
	
	@Autowired
	private ArtifactService artifactService;

	@Override
	public void saveRegistries(List<RegistryRequest> registries) {
		Map<String, Set<Artifact>> map = new HashMap<>();
		
		registries.forEach(r -> convertRegistriesToArtifacts(r, map));
		
		map.forEach((key, artifacts) -> saveTruck(key, artifacts));
	}
	
	private void convertRegistriesToArtifacts(RegistryRequest registry, Map<String, Set<Artifact>> artifactsMap) {
		Artifact artifact = null;
		
		if(registry.getArtifactType() == ArtifactTypeEnum.SOFTWARE) {
			artifact = new SoftwareArtifact(registry.getCode());

		} else if(registry.getArtifactType() == ArtifactTypeEnum.HARDWARE) {
			artifact = new HardwareArtifact(registry.getCode());
		}

		if(artifactsMap.containsKey(registry.getVin())) {
			artifactsMap.get(registry.getVin()).add(artifact);
			
		} else {
			Set<Artifact> artifacts = new HashSet<>();
			artifacts.add(artifact);
			artifactsMap.put(registry.getVin(), artifacts);
		}
	}

	private Long checkExistence(Artifact a) {

		ArtifactResponse artifact = artifactService.findByCode(a.getCode());
		
		if(artifact != null) {
			return artifact.getId();
		}
		
		return null;
	}

	private void saveTruck(String key, Set<Artifact> artifacts) {
		final Feature feature;
		Truck truck = null;
		
		Optional<Truck> returnedTruck = repository.findByVin(key);
		
		for(Artifact a: artifacts) {
			a.setId(checkExistence(a));
		}
		
		if(!returnedTruck.isPresent()) {
			truck = new Truck();
			feature = new Feature();
			
			truck.setVIN(key);
			truck.setFeature(feature);
			
			truck = repository.save(truck);
			
			truck.setFeature(feature);
			feature.setRequiredArtifact(artifacts);
		} else {
			truck = returnedTruck.get();
			feature = truck.getFeature();
			
			artifacts.stream().forEach(n -> 
			{
				if(feature.getRequiredArtifact().stream().noneMatch(a -> a.getCode().equals(n.getCode()))) {
					feature.getRequiredArtifact().add(n);	
				}
			});
		}

		repository.saveAndFlush(truck);
	}	
}