package man.fota.repository;

import java.util.List;

import man.fota.entity.Truck;
import man.fota.util.ArtifactMode;

public interface TruckCustomizedRepository{

	public List<Truck> findByArtifact(String code, ArtifactMode mode);
	
}