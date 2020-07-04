package man.fota.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feature")
public class Feature implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Artifact> requiredArtifact;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Artifact> forbiddenArtifact;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Artifact> getRequiredArtifact() {
		return requiredArtifact;
	}

	public void setRequiredArtifact(Set<Artifact> requiredArtifact) {
		this.requiredArtifact = requiredArtifact;
	}

	public Set<Artifact> getForbiddenArtifact() {
		return forbiddenArtifact;
	}

	public void setForbiddenArtifact(Set<Artifact> forbiddenArtifact) {
		this.forbiddenArtifact = forbiddenArtifact;
	}
}