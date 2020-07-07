package man.fota.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import man.fota.entity.FeatureRequirement;
import man.fota.repository.FeatureRepository;
import man.fota.response.dto.FeatureResponse;
import man.fota.service.FeatureService;

@Service
public class FeatureServiceImpl implements FeatureService {

	@Autowired
	private FeatureRepository repository;

	@Override
	public List<FeatureResponse> getAll() {
		List<FeatureResponse> response = new ArrayList<>();
		List<FeatureRequirement> features = repository.findAll();
		
		if(features != null) {
			response = features
					.stream()
					.map(FeatureResponse::tranformId)
					.collect(Collectors.toList());
		}
		
		return response;
	}
}