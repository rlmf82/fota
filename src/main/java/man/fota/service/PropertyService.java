package man.fota.service;

import man.fota.entity.PropertyKeyEnum;
import man.fota.response.dto.PropertyResponse;

public interface PropertyService {

	public PropertyResponse getProperty(PropertyKeyEnum key);

}