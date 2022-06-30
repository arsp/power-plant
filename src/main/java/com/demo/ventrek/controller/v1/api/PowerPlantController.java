package com.demo.ventrek.controller.v1.api;

import com.demo.ventrek.dto.request.BatteryDetailsRequestDto;
import com.demo.ventrek.dto.request.PostcodeRangeDto;
import com.demo.ventrek.dto.response.BatteryByPostcodeRangeResponse;
import com.demo.ventrek.model.Battery;
import com.demo.ventrek.service.PowerPlantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/power-plant")
public class PowerPlantController {

    @Autowired
    private ModelMapper modelMapper;

    private final PowerPlantService powerPlantService;

    public PowerPlantController(PowerPlantService powerPlantService) {
        this.powerPlantService = powerPlantService;
    }

    @PostMapping("batteries")
    public void createBatteryList(@RequestBody List<BatteryDetailsRequestDto> list){
        powerPlantService.createBatteryList(this.convertToEntity(list));
    }

    @PostMapping("postcode")
    public BatteryByPostcodeRangeResponse getBatteryByPostcodeRange(@RequestBody PostcodeRangeDto postcodeRangeDto){
        return powerPlantService.getBatteryByPostcodeRange(postcodeRangeDto);
    }

    private List<Battery> convertToEntity(List<BatteryDetailsRequestDto> list){
        List<Battery> battery = Arrays.asList(modelMapper.map(list, Battery[].class));
        return battery;
    }

}
