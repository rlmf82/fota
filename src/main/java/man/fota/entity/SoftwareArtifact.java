package man.fota.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Software")
@DiscriminatorValue("Software")
public class SoftwareArtifact extends Artifact{

}