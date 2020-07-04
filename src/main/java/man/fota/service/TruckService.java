package man.fota.service;

import java.util.List;

import man.fota.request.dto.RegistryRequest;

public interface TruckService {

	public void saveRegistries(List<RegistryRequest> registries);

}