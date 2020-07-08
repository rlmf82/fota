package man.fota.service;

import java.util.List;

import man.fota.entity.PropertyKeyEnum;
import man.fota.exception.PropertyNotFound;
import man.fota.request.dto.UpdatePropertyRequest;
import man.fota.response.dto.PropertyResponse;

public interface PropertyService {

	public PropertyResponse getProperty(PropertyKeyEnum key);

	public List<PropertyResponse> getAll();
	
	public void updateProperty(UpdatePropertyRequest request) throws PropertyNotFound;
}