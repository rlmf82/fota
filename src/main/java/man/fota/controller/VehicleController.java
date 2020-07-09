package man.fota.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import man.fota.response.dto.ArtifactResponse;
import man.fota.response.dto.TruckResponse;
import man.fota.service.TruckService;
import man.fota.util.ArtifactMode;

@RestController
@RequestMapping("vehicles")
@Api(value = "Vehicles Controller", description = "Available user operations")
public class VehicleController {

    private TruckService truckServices;

    public VehicleController(TruckService truckServices) {
    	this.truckServices = truckServices;
	}
    
    @GetMapping
    @ApiOperation(value = "returns a list of all vehicles")
    public List<TruckResponse> getAll() throws Exception {
        return truckServices.getAll();
    }
    
    @GetMapping("/{vin}")
    @ApiOperation(value = "gives all features that can/cannot be installed for the corresponding vin")
    public TruckResponse getByVIN(@PathVariable(name = "vin") String vin) throws Exception {
        return truckServices.getByVIN(vin);
    }
    
    @GetMapping("/{vin}/installable")
    @ApiOperation(value = "gives all the features that can be installed for the corresponding vin")
    public Set<ArtifactResponse> getInstallableByVIN(@PathVariable(name = "vin") String vin) throws Exception {
        return truckServices.getArtifactsByVIN(vin, ArtifactMode.INSTALLABLE);
    }
    
    @GetMapping("/{vin}/incompatible")
    @ApiOperation(value = "gives all the features that cannot be installed for the corresponding vin")
    public Set<ArtifactResponse> getIncompatibleByVIN(@PathVariable(name = "vin") String vin) throws Exception {
        return truckServices.getArtifactsByVIN(vin, ArtifactMode.INCOMPATIBLE);
    }
}