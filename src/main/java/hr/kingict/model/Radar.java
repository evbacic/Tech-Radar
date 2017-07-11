package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * A model class which represents Radar entity from the database
 */
@Entity
public class Radar implements Serializable{


    private static final long serialVersionUID = -3148830585225090453L;
    /**
     * Radar id used as primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * TechGroup object whose id is used as foreign key
     */
    @ManyToOne
    @JoinColumn(name = "tech_group_id")
    private TechGroup techGroupRadar;
    /**
     * Date object used to represent the starting date of period when radar is used
     */
    @Column(name = "START_DATE")
    private Date start;
    /**
     * Date object used to represent the ending date of period when radar was used
     */
    @Column(name = "END_DATE")
    private Date end;
    /**
     * List of RadarTechnologies that use Radar id as foreign key
     */
    @OneToMany(mappedBy = "radar", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RadarTechnologies> radarTechnologiesList;

    /**
     * A default constructor for Radar model
     */
    public Radar() {
    }

    /**
     * A constructor with parameters for Radar model
     * @param techGroupRadar TechGroup object
     * @param start          start date
     * @param end            end date
     */
    public Radar(TechGroup techGroupRadar, Date start, Date end) {
        this.techGroupRadar = techGroupRadar;
        this.start = start;
        this.end = end;
    }

    /**
     * Getter for radar id
     * @return radar id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for radar id
     * @param id radar id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for TechGroup object
     * @return TechGroup object
     */
    public TechGroup getTechGroupRadar() {
        return techGroupRadar;
    }

    /**
     * Setter for TechGroup object
     * @param techGroupRadar TechGroup object
     */
    public void setTechGroupRadar(TechGroup techGroupRadar) {
        this.techGroupRadar = techGroupRadar;
    }

    /**
     * Getter for start date
     * @return start date
     */
    public Date getStart() {
        return start;
    }

    /**
     * Setter for start date
     * @param start start date
     */
    public void setStart(Date start) {
        this.start = start;
    }

    /**
     * Getter for end date
     * @return end date
     */
    public Date getEnd() {
        return end;
    }

    /**
     * Setter for end date
     * @param end end date
     */
    public void setEnd(Date end) {
        this.end = end;
    }

    /**
     * Getter for the list of RadarTechnologies entities that use Radar id as foreign key
     * @return list of RadarTechnologies objects
     */
    public List<RadarTechnologies> getRadarTechnologiesList() {
        return radarTechnologiesList;
    }

    /**
     * Setter for the list of RadarTechnologies entities that use Radar id as foreign key
     * @param radarTechnologiesList list of RadarTechnologies objects
     */
    public void setRadarTechnologiesList(List<RadarTechnologies> radarTechnologiesList) {
        this.radarTechnologiesList = radarTechnologiesList;
    }
}
