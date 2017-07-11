package hr.kingict.model;

/**
 * A model class that represents objects used in Ajax post request
 * when user is updating a radar
 */
public class CategoryUpdate {

    /**
     * Technology id
     */
    private Long id;
    /**
     * Category id
     */
    private Long catId;
    /**
     * Radar id
     */
    private Long radId;

    /**
     * Getter for technology id
     * @return technology id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for technology id
     * @param id technology id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for category id
     * @return category id
     */
    public Long getCatId() {
        return catId;
    }

    /**
     * Setter for category id
     * @param catId category id
     */
    public void setCatId(Long catId) {
        this.catId = catId;
    }

    /**
     * Getter for radar id
     * @return radar id
     */
    public Long getRadId() {
        return radId;
    }

    /**
     * Setter for radar id
     * @param radId radar id
     */
    public void setRadId(Long radId) {
        this.radId = radId;
    }
}
