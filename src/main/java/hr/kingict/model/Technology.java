package hr.kingict.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by luka.crnjakovic on 2.6.2017..
 */
@Entity
public class Technology implements Serializable{
    private static final long serialVersionUID = 421139459241691794L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "tech_group_id")
    //@JsonBackReference
    private TechGroup techGroup;
    @ManyToOne
    @JoinColumn(name = "category_id")
    //@JsonBackReference
    private Category category;

    public Technology() {
    }

    public Technology(String name, String description, TechGroup techGroup, Category category) {
        super();
        this.name = name;
        this.description = description;
        this.techGroup = techGroup;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return "ID: " + getId() + "\n" + "Name: " + getName() + "\n" + "---------------";
    }
}
