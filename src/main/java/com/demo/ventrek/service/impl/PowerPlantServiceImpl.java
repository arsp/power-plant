package com.demo.ventrek.service.impl;

import com.demo.ventrek.dao.PowerPlantDao;
import com.demo.ventrek.dto.request.PostcodeRangeDto;
import com.demo.ventrek.dto.response.BatteryByPostcodeRangeResponse;
import com.demo.ventrek.model.Battery;
import com.demo.ventrek.service.PowerPlantService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PowerPlantServiceImpl implements PowerPlantService {

    private final PowerPlantDao powerPlantDao;

    public PowerPlantServiceImpl(PowerPlantDao powerPlantDao){
        this.powerPlantDao = powerPlantDao;
    }

    @Override
    public void createBatteryList(List<Battery> list) {
        powerPlantDao.createBatteryList(list);
    }

    @Override
    public BatteryByPostcodeRangeResponse getBatteryByPostcodeRange(PostcodeRangeDto postcodeRangeDto) {
        List<Battery> batteryList = powerPlantDao.getBatteryByPostcodeRange(postcodeRangeDto);

        List<String> batteryNames = batteryList.stream()
                                        .map(Battery::getName)
                                        .collect(Collectors.toList());
        double average  = batteryList.stream()
                                .mapToDouble(i->i.getCapacity())
                                .average()
                                .orElse(0.0);

        int total = batteryList.stream()
                        .mapToInt(x -> x.getCapacity())
                        .sum();

        BatteryByPostcodeRangeResponse response = new BatteryByPostcodeRangeResponse();
        response.setBatteryNames(batteryNames);
        response.setAverageWattCapacity(average);
        response.setTotalWattCapacity(total);

        return response;
    }
}
