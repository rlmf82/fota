package man.fota.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import man.fota.entity.Artifact;
import man.fota.repository.ArtifactRepository;
import man.fota.response.dto.ArtifactResponse;
import man.fota.service.ArtifactService;

@Service
public class ArtifactServiceImpl implements ArtifactService {

	@Autowired
	private ArtifactRepository repository;

	@Override
	public ArtifactResponse findByCode(String code) {
		Optional<Artifact> artifact = repository.findByCode(code);
		
		if(artifact.isPresent()) {
			return ArtifactResponse.transform(artifact.get());
		}
		
		return null;
	}

	@Override
	public List<ArtifactResponse> findAll() {
		List<ArtifactResponse> response = new ArrayList<>();
		
		List<Artifact> artifacts = repository.findAll();
		
		if(artifacts != null) {
			response = artifacts
					.stream()
					.map(ArtifactResponse::transform)
					.collect(Collectors.toList());
		}
		
		return response;
	}

	
}