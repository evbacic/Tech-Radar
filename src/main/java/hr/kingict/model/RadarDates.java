package hr.kingict.model;

/**
 * Created by luka.crnjakovic on 5.7.2017..
 */
public class RadarDates {

    private String start;
    private String end;

    public RadarDates(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
