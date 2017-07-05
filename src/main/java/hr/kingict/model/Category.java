package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by luka.crnjakovic on 2.6.2017..
 */
@Entity
public class Category implements Serializable{
    private static final long serialVersionUID = -8745726839503998411L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RadarTechnologies> radarTechnologiesList;

    public Category() {
    }

    public Category(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
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

    public List<RadarTechnologies> getRadarTechnologiesList() {
        return radarTechnologiesList;
    }

    public void setRadarTechnologiesList(List<RadarTechnologies> radarTechnologiesList) {
        this.radarTechnologiesList = radarTechnologiesList;
    }
}
