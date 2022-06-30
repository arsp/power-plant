package com.demo.ventrek.service;

import com.demo.ventrek.dto.request.PostcodeRangeDto;
import com.demo.ventrek.dto.response.BatteryByPostcodeRangeResponse;
import com.demo.ventrek.model.Battery;

import java.util.List;

public interface PowerPlantService {
    void createBatteryList(List<Battery> list);

    BatteryByPostcodeRangeResponse getBatteryByPostcodeRange(PostcodeRangeDto postcodeRangeDto);
}
