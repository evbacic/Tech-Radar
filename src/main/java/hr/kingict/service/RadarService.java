package hr.kingict.service;

import hr.kingict.model.NewRadar;
import hr.kingict.model.Radar;

import java.sql.Date;
import java.util.List;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
public interface RadarService {
    List<Date> getCurrentRadarDates(Long techGroupId);
    Radar getNewestRadar(Long techGroupId);
    Radar getRadarByDate(Date date, Long techGroupId);
    void addNewRadar(NewRadar newRadar);
}
