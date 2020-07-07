package man.fota.response.dto;

import java.io.Serializable;

import man.fota.entity.Truck;

public class TruckResponse implements Serializable{

	private static final long serialVersionUID = 1L;

    private String vin;

    private FeatureResponse feature;
	
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

	public static TruckResponse transform(Truck truck) {
		TruckResponse response = new TruckResponse();
		
		response.setVin(truck.getVIN());
		response.setFeature(FeatureResponse.transform(truck.getFeature()));
		
		return response;
	}
}