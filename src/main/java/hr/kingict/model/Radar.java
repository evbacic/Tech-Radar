package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by luka.crnjakovic on 5.7.2017..
 */
@Entity
public class Radar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tech_group_id")
    private TechGroup techGroupRadar;
    @Column(name = "START_DATE")
    private Date start;
    @Column(name = "END_DATE")
    private Date end;
    @OneToMany(mappedBy = "radar", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RadarTechnologies> radarTechnologiesList;

    public Radar() {
    }

    public Radar(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Radar(TechGroup techGroupRadar, Date start, Date end) {
        this.techGroupRadar = techGroupRadar;
        this.start = start;
        this.end = end;
    }

    public List<RadarTechnologies> getRadarTechnologiesList() {
        return radarTechnologiesList;
    }

    public void setRadarTechnologiesList(List<RadarTechnologies> radarTechnologiesList) {
        this.radarTechnologiesList = radarTechnologiesList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TechGroup getTechGroupRadar() {
        return techGroupRadar;
    }

    public void setTechGroupRadar(TechGroup techGroupRadar) {
        this.techGroupRadar = techGroupRadar;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
