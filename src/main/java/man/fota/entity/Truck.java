package man.fota.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class Truck implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vin")
	private String VIN;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="feature_id")
    private FeatureRequirement feature;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public FeatureRequirement getFeature() {
		return feature;
	}

	public void setFeature(FeatureRequirement feature) {
		this.feature = feature;
	}
}
