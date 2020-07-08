package man.fota.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import man.fota.request.dto.UpdatePropertyRequest;
import man.fota.response.dto.PropertyResponse;
import man.fota.service.PropertyService;

@RestController
@RequestMapping("properties")
public class PropertiesController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public List<PropertyResponse> getAll() throws Exception {
    	return propertyService.getAll();
    }
    
    @PutMapping
    public void updateArtifact(@Valid @RequestBody UpdatePropertyRequest request) throws Exception {
        propertyService.updateProperty(request);
    }
}