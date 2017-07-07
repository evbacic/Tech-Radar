package hr.kingict.model;

/**
 * Created by luka.crnjakovic on 7.7.2017..
 */
public class NewRadar {
    private Long techGroupId;
    private String startDate;
    private String endDate;

    public Long getTechGroupId() {
        return techGroupId;
    }

    public void setTechGroupId(Long techGroupId) {
        this.techGroupId = techGroupId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
