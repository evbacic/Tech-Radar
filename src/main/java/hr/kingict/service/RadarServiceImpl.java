package hr.kingict.service;

import hr.kingict.model.NewRadar;
import hr.kingict.model.Radar;
import hr.kingict.repository.RadarRepository;
import hr.kingict.repository.TechGroupRepository;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
@Component("radarService")
public class RadarServiceImpl implements RadarService{

    private final RadarRepository radarRepository;

    private final TechGroupRepository techGroupRepository;

    public RadarServiceImpl(RadarRepository radarRepository, TechGroupRepository techGroupRepository) {
        this.radarRepository = radarRepository;
        this.techGroupRepository = techGroupRepository;
    }

    @Override
    public List<Date> getCurrentRadarDates(Long techGroupId) {
        return radarRepository.findAllDates(techGroupRepository.findOne(techGroupId));
    }

    @Override
    public Radar getNewestRadar(Long techGroupId) {
        List<Radar> radarList = radarRepository.findRecentByGroup(techGroupRepository.findOne(techGroupId));
        return radarList.get(0);
    }

    @Override
    public Radar getRadarByDate(Date date, Long techGroupId) {
        List<Radar> radarList = radarRepository.findByDates(date);
        for(Radar r: radarList){
            if(r.getTechGroupRadar().getId().equals(techGroupId)){
                return r;
            }
        }
        return null;
    }

    @Override
    public void addNewRadar(NewRadar newRadar) {
        radarRepository.saveAndFlush(new Radar(techGroupRepository.findOne(newRadar.getTechGroupId()), Date.valueOf(newRadar.getStartDate()), Date.valueOf(newRadar.getEndDate())));
    }
}
