package man.fota.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Artifact> requiredArtifact;
    
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Artifact> forbiddenArtifact;
}