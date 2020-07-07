package man.fota.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import man.fota.response.dto.ArtifactResponse;
import man.fota.response.dto.TruckResponse;
import man.fota.service.TruckService;
import man.fota.util.ArtifactMode;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    private TruckService truckServices;

    public VehicleController(TruckService truckServices) {
    	this.truckServices = truckServices;
	}
    
    @GetMapping
    public List<TruckResponse> getAll() throws Exception {
        return truckServices.getAll();
    }
    
    @GetMapping("/{vin}")
    public TruckResponse getByVIN(@PathVariable(name = "vin") String vin) throws Exception {
        return truckServices.getByVIN(vin);
    }
    
    @GetMapping("/{vin}/installable")
    public Set<ArtifactResponse> getInstallableByVIN(@PathVariable(name = "vin") String vin) throws Exception {
        return truckServices.getArtifactsByVIN(vin, ArtifactMode.INSTALLABLE);
    }
    
    @GetMapping("/{vin}/incompatible")
    public Set<ArtifactResponse> getIncompatibleByVIN(@PathVariable(name = "vin") String vin) throws Exception {
        return truckServices.getArtifactsByVIN(vin, ArtifactMode.INCOMPATIBLE);
    }
}