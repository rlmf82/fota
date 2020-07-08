package man.fota.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.el.PropertyNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import man.fota.entity.Property;
import man.fota.entity.PropertyKeyEnum;
import man.fota.exception.PropertyNotFound;
import man.fota.repository.PropertyRepository;
import man.fota.request.dto.UpdatePropertyRequest;
import man.fota.response.dto.PropertyResponse;
import man.fota.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyRepository repository;
	
	@Override
	public PropertyResponse getProperty(PropertyKeyEnum key) {
		
		Optional<Property> property = repository.findById(key);
		
		if(!property.isPresent()) {
			throw new PropertyNotFoundException();
		}
		
		return PropertyResponse.tranform(property.get());
	}

	@Override
	public void updateProperty(UpdatePropertyRequest request) throws PropertyNotFound {
		
		Optional<Property> property = repository.findById(request.getKey());
		
		if(!property.isPresent()) {
			throw new PropertyNotFound(request.getKey().toString());
		}
		
		property.get().setValue(request.getValue());
		
		repository.save(property.get());
	}

	@Override
	public List<PropertyResponse> getAll() {
		List<PropertyResponse> response = new ArrayList<>();
		List<Property> properties = repository.findAll();

		if(properties != null) {
			response = properties
					.stream()
					.map(PropertyResponse::tranform)
					.collect(Collectors.toList());
		}
		
		return response;
	}	
}