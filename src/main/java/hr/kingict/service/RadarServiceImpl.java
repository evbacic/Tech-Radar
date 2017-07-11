package hr.kingict.service;

import hr.kingict.model.NewRadar;
import hr.kingict.model.Radar;
import hr.kingict.repository.RadarRepository;
import hr.kingict.repository.TechGroupRepository;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * A class which is an implementation of RadarService interface
 */
@Component("radarService")
public class RadarServiceImpl implements RadarService{

    /**
     * RadarRepository object used to access Radar information from the data access layer
     */
    private final RadarRepository radarRepository;
    /**
     * TechGroupRepository object used to access TechGroup information from the data access layer
     */
    private final TechGroupRepository techGroupRepository;

    /**
     * A constructor with parameters for implementation of RadarService
     * @param radarRepository RadarRepository object
     * @param techGroupRepository TechGroupRepository object
     */
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
