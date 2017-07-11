package hr.kingict.model;

/**
 * A model class that represents an object used in ajax post request
 * when user is creating a new radar
 */
public class NewRadar {

    /**
     * TechGroup id
     */
    private Long techGroupId;
    /**
     * New radar start date
     */
    private String startDate;
    /**
     * New radar end date
     */
    private String endDate;

    /**
     * Getter for techGroup id
     * @return techGroup id
     */
    public Long getTechGroupId() {
        return techGroupId;
    }

    /**
     * Setter for techGroup id
     * @param techGroupId techGroup id
     */
    public void setTechGroupId(Long techGroupId) {
        this.techGroupId = techGroupId;
    }

    /**
     * Getter for start date
     * @return start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Setter for start date
     * @param startDate start date
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Getter for end date
     * @return end date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Setter for end date
     * @param endDate end date
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
