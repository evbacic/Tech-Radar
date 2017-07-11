package hr.kingict.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A model class which represents RadarTechnologies entity from the database
 */
@Entity
@Table(name = "RADAR_TECHNOLOGIES")
public class RadarTechnologies implements Serializable{

    private static final long serialVersionUID = -4037863664022101329L;
    /**
     * RadarTechnologies id used as primary key
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Radar object whose id is used as foreign key
     */
    @ManyToOne
    @JoinColumn(name = "radar_id")
    private Radar radar;
    /**
     * Technology object whose id is used as foreign key
     */
    @ManyToOne
    @JoinColumn(name = "tech_id")
    private Technology technology;
    /**
     * Category object whose id is used as foreign key
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * A default constructor for RadarTechnologies model
     */
    public RadarTechnologies() {
    }

    /**
     * A constructor with parameters for RadarTechnologies model
     * @param radar      Radar object
     * @param technology Technology object
     * @param category   Category object
     */
    public RadarTechnologies(Radar radar, Technology technology, Category category) {
        this.radar = radar;
        this.technology = technology;
        this.category = category;
    }

    /**
     * Getter for radarTechnologies id
     * @return radarTechnologies id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for radarTechnologies id
     * @param id radarTechnologies id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for Radar object
     * @return Radar object
     */
    public Radar getRadar() {
        return radar;
    }

    /**
     * Setter for Radar object
     * @param radar Radar object
     */
    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    /**
     * Getter for Technology object
     * @return Technology object
     */
    public Technology getTechnology() {
        return technology;
    }

    /**
     * Setter for Technology object
     * @param technology Technology object
     */
    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    /**
     * Getter for Category object
     * @return Category object
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Setter for Category object
     * @param category Category object
     */
    public void setCategory(Category category) {
        this.category = category;
    }
}
