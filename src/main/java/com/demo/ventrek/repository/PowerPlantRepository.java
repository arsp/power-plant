package com.demo.ventrek.repository;

import com.demo.ventrek.dto.request.PostcodeRangeDto;
import com.demo.ventrek.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PowerPlantRepository extends JpaRepository<Battery, Long> {
    @Query(value = "SELECT * FROM battery WHERE postcode >= ?1 AND postcode <= ?2 ORDER BY name ASC", nativeQuery = true)
    List<Battery> getBatteryByPostcodeRange(String from, String to);
}