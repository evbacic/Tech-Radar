package hr.kingict.model;

/**
 * A model class that represents an object used in ajax post request
 * when user is deleting a technology
 */
public class TechnologyToDelete {

    /**
     * Technology id
     */
    private Long techId;

    /**
     * Getter for Technology id
     * @return Technology id
     */
    public Long getTechId() {
        return techId;
    }

    /**
     * Setter for Technology id
     * @param techId Technology id
     */
    public void setTechId(Long techId) {
        this.techId = techId;
    }
}
