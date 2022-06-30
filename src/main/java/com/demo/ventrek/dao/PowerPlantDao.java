package com.demo.ventrek.dao;

import com.demo.ventrek.dto.request.PostcodeRangeDto;
import com.demo.ventrek.model.Battery;

import java.util.List;

public interface PowerPlantDao {
    void createBatteryList(List<Battery> list);

    List<Battery> getBatteryByPostcodeRange(PostcodeRangeDto postcodeRangeDto);
}
