package com.demo.ventrek.dao.impl;

import com.demo.ventrek.dao.PowerPlantDao;
import com.demo.ventrek.dto.request.PostcodeRangeDto;
import com.demo.ventrek.model.Battery;
import com.demo.ventrek.repository.PowerPlantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PowerPlantDaoImpl implements PowerPlantDao {

    private PowerPlantRepository powerPlantRepository;

    public PowerPlantDaoImpl(PowerPlantRepository powerPlantRepository){
        this.powerPlantRepository = powerPlantRepository;
    }
    @Override
    public void createBatteryList(List<Battery> list) {
        powerPlantRepository.saveAll(list);
    }

    @Override
    public List<Battery> getBatteryByPostcodeRange(PostcodeRangeDto postcodeRangeDto) {
        return powerPlantRepository.getBatteryByPostcodeRange(postcodeRangeDto.getFrom(), postcodeRangeDto.getTo());
    }
}
