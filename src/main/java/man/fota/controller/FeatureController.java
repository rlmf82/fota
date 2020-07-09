package man.fota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import man.fota.response.dto.ArtifactResponse;
import man.fota.response.dto.TruckResponse;
import man.fota.service.ArtifactService;
import man.fota.service.TruckService;
import man.fota.util.ArtifactMode;

@RestController
@RequestMapping("features")
@Api(value = "Features Controller", description = "Available user operations")
public class FeatureController {

    @Autowired
    private ArtifactService artifactService;

    @Autowired
    private TruckService truckService;
        
    @GetMapping("/{feature}")
    @ApiOperation(value = "gives all vins that can/cannot install the corresponding feature")
    public List<TruckResponse> getVinByArtifact(@PathVariable(name = "feature") String code) throws Exception {
        return truckService.getTrucksByArtifact(code, ArtifactMode.ALL);
    }
    
    @GetMapping("/{feature}/incompatible")
    @ApiOperation(value = "gives all the vins that cannot install the corresponding feature")
    public List<TruckResponse> getVinByIncompatibles(@PathVariable(name = "feature") String code) throws Exception {
        return truckService.getTrucksByArtifact(code, ArtifactMode.INCOMPATIBLE);
    }
    
    @GetMapping("/{feature}/installable")
    @ApiOperation(value = "gives all the vins that can install the corresponding feature")
    public List<TruckResponse> getVinByInstallables(@PathVariable(name = "feature") String code) throws Exception {
        return truckService.getTrucksByArtifact(code, ArtifactMode.INSTALLABLE);
    }
    
    @GetMapping
    @ApiOperation(value = "returns a list of all features.")
    public List<ArtifactResponse> getAll() throws Exception {
        return artifactService.findAll();
    }
}