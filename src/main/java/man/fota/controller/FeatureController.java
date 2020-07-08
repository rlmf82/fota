package man.fota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import man.fota.response.dto.ArtifactResponse;
import man.fota.response.dto.TruckResponse;
import man.fota.service.ArtifactService;
import man.fota.service.TruckService;
import man.fota.util.ArtifactMode;

@RestController
@RequestMapping("features")
public class FeatureController {

    @Autowired
    private ArtifactService artifactService;

    @Autowired
    private TruckService truckService;
        
    @GetMapping("/{feature}")
    public List<TruckResponse> getVinByArtifact(@PathVariable(name = "feature") String code) throws Exception {
        return truckService.getTrucksByArtifact(code, ArtifactMode.ALL);
    }
    
    @GetMapping("/{feature}/incompatible")
    public List<TruckResponse> getVinByIncompatibles(@PathVariable(name = "feature") String code) throws Exception {
        return truckService.getTrucksByArtifact(code, ArtifactMode.INCOMPATIBLE);
    }
    
    @GetMapping("/{feature}/installable")
    public List<TruckResponse> getVinByInstallables(@PathVariable(name = "feature") String code) throws Exception {
        return truckService.getTrucksByArtifact(code, ArtifactMode.INSTALLABLE);
    }
    
    @GetMapping
    public List<ArtifactResponse> getAll() throws Exception {
        return artifactService.findAll();
    }
}