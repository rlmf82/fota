package man.fota.response.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import man.fota.entity.FeatureRequirement;
import man.fota.entity.Truck;

@JsonInclude(Include.NON_NULL)
public class TruckResponse implements Serializable{

	private static final long serialVersionUID = 1L;

    private String vin;

    private FeatureResponse feature;
	
    private String condition;
    
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public FeatureResponse getFeature() {
		return feature;
	}

	public void setFeature(FeatureResponse feature) {
		this.feature = feature;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public static TruckResponse transform(Truck truck) {
		TruckResponse response = new TruckResponse();
		
		response.setVin(truck.getVIN());
		response.setFeature(FeatureResponse.transform(truck.getFeature()));
		
		return response;
	}
	
	public static TruckResponse transform(Truck truck, String artifactCode) {
		TruckResponse response = new TruckResponse();
		
		response.setVin(truck.getVIN());
		
		FeatureRequirement featureRequirement = truck.getFeature();
		
		if(featureRequirement.getForbiddenArtifact().stream().anyMatch(a -> a.getCode().equals(artifactCode))) {
			response.setCondition("Incompatible");
		} else if(featureRequirement.getRequiredArtifact().stream().anyMatch(a -> a.getCode().equals(artifactCode))) {
			response.setCondition("Installable");
		}
		
		return response;
	}
}