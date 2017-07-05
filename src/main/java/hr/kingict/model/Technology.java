package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by luka.crnjakovic on 2.6.2017..
 */
@Entity
@SequenceGenerator(name = "tech_seq", sequenceName = "technology_serial", allocationSize = 1)
public class Technology implements Serializable{
    private static final long serialVersionUID = 421139459241691794L;
    @Id
    @GeneratedValue(generator = "tech_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "tech_group_id")
    //@JsonBackReference
    private TechGroup techGroup;
    @OneToMany(mappedBy = "technology", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<RadarTechnologies> radarTechnologiesList;

    public Technology() {
    }

    public Technology(String name, String description, TechGroup techGroup) {
        super();
        this.name = name;
        this.description = description;
        this.techGroup = techGroup;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TechGroup getTechGroup() {
        return techGroup;
    }

    public void setTechGroup(TechGroup techGroup) {
        this.techGroup = techGroup;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + "\n" + "Name: " + getName() + "\n" + "---------------";
    }
}
