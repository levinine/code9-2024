package com.levinine.codenine.booking.controller;

import com.levinine.codenine.booking.dto.PropertyDto;
import com.levinine.codenine.booking.service.PropertyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@AllArgsConstructor
@Slf4j
public class PropertyController {

  private final PropertyService propertyService;

  @PostMapping
  public PropertyDto createProperty(@RequestBody PropertyDto propertyDto) {
    log.info("Saving new property: {}", propertyDto.getName());
    return propertyService.saveProperty(propertyDto);
  }

  @GetMapping
  public List<PropertyDto> findAllProperties() {
    log.info("Finding all properties");
    return propertyService.findAllProperties();
  }

}
