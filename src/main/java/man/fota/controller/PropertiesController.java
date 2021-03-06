package man.fota.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import man.fota.request.dto.UpdatePropertyRequest;
import man.fota.response.dto.PropertyResponse;
import man.fota.service.PropertyService;

@RestController
@RequestMapping("properties")
@Api(value = "Properties Controller", description = "Available user operations")
public class PropertiesController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    @ApiOperation(value = "returns a list of all properties")
    public List<PropertyResponse> getAll() throws Exception {
    	return propertyService.getAll();
    }
    
    @PutMapping
    @ApiOperation(value = "update a property value")
    public void updateArtifact(@Valid @RequestBody UpdatePropertyRequest request) throws Exception {
        propertyService.updateProperty(request);
    }
}