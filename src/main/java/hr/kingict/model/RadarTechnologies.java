package hr.kingict.model;

import javax.persistence.*;

/**
 * Created by luka.crnjakovic on 5.7.2017..
 */
@Entity
@Table(name = "RADAR_TECHNOLOGIES")
public class RadarTechnologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "radar_id")
    private Radar radar;
    @ManyToOne
    @JoinColumn(name = "tech_id")
    private Technology technology;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public RadarTechnologies() {
    }

    public RadarTechnologies(Radar radar, Technology technology, Category category) {
        this.radar = radar;
        this.technology = technology;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Radar getRadar() {
        return radar;
    }

    public void setRadar(Radar radar) {
        this.radar = radar;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
