package man.fota.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Hardware")
@DiscriminatorValue("Hardware")
public class HardwareArtifact extends Artifact{

	
}