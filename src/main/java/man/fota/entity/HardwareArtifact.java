package man.fota.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Hardware")
@DiscriminatorValue("Hardware")
public class HardwareArtifact extends Artifact{

	private static final long serialVersionUID = 1L;

	public HardwareArtifact() {}
	
	public HardwareArtifact(String code) {
		super(code);
	}
	
	@Override
	public String getDiscriminatorName() {
		return "HARDWARE";
	}
	
}