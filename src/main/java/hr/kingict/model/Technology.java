package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * A model class which represents Technology entity from the database
 */
@Entity
@SequenceGenerator(name = "tech_seq", sequenceName = "technology_serial", allocationSize = 1)
public class Technology implements Serializable{

    private static final long serialVersionUID = 421139459241691794L;
    /**
     * Technology id used as primary key
     */
    @Id
    @GeneratedValue(generator = "tech_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    /**
     * Technology name
     */
    private String name;
    /**
     * Technology description
     */
    private String description;
    /**
     * TechGroup object whose id is used as foreign key
     */
    @ManyToOne
    @JoinColumn(name = "tech_group_id")
    private TechGroup techGroup;
    /**
     * List of RadarTechnologies that use Radar id as foreign key
     */
    @OneToMany(mappedBy = "technology", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RadarTechnologies> radarTechnologiesList;

    /**
     * A default constructor for Technology model
     */
    public Technology() {
    }

    /**
     * A constructor with parameters for Technology model
     * @param name        Technology id
     * @param description Technology description
     * @param techGroup   TechGroup object
     */
    public Technology(String name, String description, TechGroup techGroup) {
        super();
        this.name = name;
        this.description = description;
        this.techGroup = techGroup;
    }

    /**
     * Getter for Technology id
     * @return Technology id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for Technology id
     * @param id Technology id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for Technology name
     * @return Technology name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for Technology name
     * @param name Technology name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for Technology description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for Technology description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for TechGroup object
     * @return TechGroup object
     */
    public TechGroup getTechGroup() {
        return techGroup;
    }

    /**
     * Setter for TechGroup object
     * @param techGroup TechGroup object
     */
    public void setTechGroup(TechGroup techGroup) {
        this.techGroup = techGroup;
    }

}
