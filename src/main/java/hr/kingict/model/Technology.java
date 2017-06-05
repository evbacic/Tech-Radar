package hr.kingict.model;

import javax.persistence.*;

/**
 * Created by luka.crnjakovic on 2.6.2017..
 */
@Entity
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "tech_group_id")
    private TechGroup techGroup;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Technology() {
    }

    public Technology(String name, String description, TechGroup techGroup, Category category) {
        this.id = id;
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
}
