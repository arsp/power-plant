package com.demo.ventrek.controller;

import com.demo.ventrek.VentrekApplication;
import com.demo.ventrek.dto.request.BatteryDetailsRequestDto;
import com.demo.ventrek.dto.request.PostcodeRangeDto;
import com.demo.ventrek.dto.response.BatteryByPostcodeRangeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = VentrekApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PowerPlantControllerTest {

    @LocalServerPort
    private int port;
    HttpHeaders headers = new HttpHeaders();
    TestRestTemplate restTemplate = new TestRestTemplate();
    private List<BatteryDetailsRequestDto> list;
    private PostcodeRangeDto postcodeRangeDto;


    @BeforeEach
    public void setup() {
        list = new ArrayList<>();
        BatteryDetailsRequestDto batteryDetailsRequestDto = new BatteryDetailsRequestDto();
        batteryDetailsRequestDto.setName("Test Battery");
        batteryDetailsRequestDto.setPostcode("9900");
        batteryDetailsRequestDto.setCapacity(7500);
        list.add(batteryDetailsRequestDto);

        postcodeRangeDto = new PostcodeRangeDto();
        postcodeRangeDto.setFrom("5000");
        postcodeRangeDto.setTo("6000");
    }

    @Test
    public void testCreateBatteryList() {

        HttpEntity<List<BatteryDetailsRequestDto>> entity = new HttpEntity<List<BatteryDetailsRequestDto>>(list, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/v1/power-plant/batteries"),
                HttpMethod.POST, entity, String.class);

        assertEquals("Success", response.getBody());
    }

    @Test
    public void testGetBatteryByPostcodeRange() {

        HttpEntity<PostcodeRangeDto> entity = new HttpEntity<PostcodeRangeDto>(postcodeRangeDto, headers);

        ResponseEntity<BatteryByPostcodeRangeResponse> response = restTemplate.exchange(
                createURLWithPort("/api/v1/power-plant/postcode"),
                HttpMethod.POST, entity, BatteryByPostcodeRangeResponse.class);

        assertEquals(37000, response.getBody().getTotalWattCapacity());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
