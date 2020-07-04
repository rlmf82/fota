package man.fota.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Software")
@DiscriminatorValue("Software")
public class SoftwareArtifact extends Artifact{

	private static final long serialVersionUID = 1L;
	
	public SoftwareArtifact() {}
	
	public SoftwareArtifact(String code) {
		super(code);
	}
	
}