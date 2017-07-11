package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * A model class which represents Category entity from the database
 */
@Entity
public class Category implements Serializable{

    private static final long serialVersionUID = -3934370267063297838L;
    /**
     * Category id used as primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Category name
     */
    private String name;
    /**
     * List of RadarTechnologies that use Category id as a foreign key
     */
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RadarTechnologies> radarTechnologiesList;

    /**
     * A default constructor for Category model
     */
    public Category() {
    }

    /**
     * A constructor with parameters for Category model
     * @param id    category id
     * @param name  category name
     */
    public Category(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * Getter for category id
     * @return category id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for category id
     * @param id category id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for category name
     * @return category name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for category name
     * @param name category name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the list of RadarTechnologies entities that use Category id as foreign key
     * @return list of RadarTechnologies objects
     */
    public List<RadarTechnologies> getRadarTechnologiesList() {
        return radarTechnologiesList;
    }

    /**
     * Setter for the list of RadarTechnologies entities that use Category id as foreign key
     * @param radarTechnologiesList list of RadarTechnologies objects
     */
    public void setRadarTechnologiesList(List<RadarTechnologies> radarTechnologiesList) {
        this.radarTechnologiesList = radarTechnologiesList;
    }
}
