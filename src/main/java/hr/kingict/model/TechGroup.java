package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by luka.crnjakovic on 2.6.2017..
 */
@Entity
@Table(name = "tech_group")
public class TechGroup implements Serializable{
    private static final long serialVersionUID = -6209291039171813639L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "techGroup", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Technology> technologyList;
    @OneToMany(mappedBy = "techGroupRadar", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Radar> radarList;

    public TechGroup() {
    }

    public TechGroup(String name) {
        super();
        this.name = name;
    }

    public List<Radar> getRadarList() {
        return radarList;
    }

    public void setRadarList(List<Radar> radarList) {
        this.radarList = radarList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void setTechnologyList(List<Technology> technologyList) {
        this.technologyList = technologyList;
    }
}
