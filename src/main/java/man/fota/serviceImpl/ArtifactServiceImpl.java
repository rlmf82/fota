package man.fota.serviceImpl;

import java.util.Optional;

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

	
}