package com.demo.ventrek.dto.response;

import com.demo.ventrek.model.Battery;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BatteryByPostcodeRangeResponse {

    private List<String> batteryNames;
    private int totalWattCapacity;
    private double averageWattCapacity;
}
