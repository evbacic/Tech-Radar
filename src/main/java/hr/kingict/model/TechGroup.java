package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * A model class which represents TechGroup entity from the database
 */
@Entity
@Table(name = "tech_group")
public class TechGroup implements Serializable{

    private static final long serialVersionUID = -1010642507237224974L;
    /**
     * TechGroup id used as primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * TechGroup name
     */
    private String name;
    /**
     * List of Technology entities that use TechGroup id as foreign key
     */
    @OneToMany(mappedBy = "techGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Technology> technologyList;
    /**
     * List of Radar entities that use TechGroup id as foreign key
     */
    @OneToMany(mappedBy = "techGroupRadar", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Radar> radarList;

    /**
     * A default constructor for TechGroup model
     */
    public TechGroup() {
    }

    /**
     * A constructor with parameters for TechGroup model
     * @param id   TechGroup id
     * @param name TechGroup name
     */
    public TechGroup(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for TechGroup id
     * @return TechGroup id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for TechGroup id
     * @param id TechGroup id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for TechGroup name
     * @return TechGroup name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for TechGroup name
     * @param name TechGroup name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for Technology objects that use TechGroup id as foreign key
     * @return list of Technology objects
     */
    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    /**
     * Setter for Technology objects that use TechGroup id as foreign key
     * @param technologyList list of Technology objects
     */
    public void setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
    }

    /**
     * Getter for Radar objects that use TechGroup id as foreign key
     * @return list of Radar objects
     */
    public List<Radar> getRadarList() {
        return radarList;
    }

    /**
     * Setter for Radar objects that use TechGroup id as foreign key
     * @param radarList list of Radar objects
     */
    public void setRadarList(List<Radar> radarList) {
        this.radarList = radarList;
    }
}
