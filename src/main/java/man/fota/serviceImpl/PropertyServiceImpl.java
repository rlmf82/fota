package man.fota.serviceImpl;

import java.util.Optional;

import javax.el.PropertyNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import man.fota.entity.Property;
import man.fota.entity.PropertyKeyEnum;
import man.fota.repository.PropertyRepository;
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
}