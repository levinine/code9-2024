package com.levinine.codenine.booking.controller;

import com.levinine.codenine.booking.dto.PropertyDto;
import com.levinine.codenine.booking.service.PropertyService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping(value = "/{id}")
  public PropertyDto findProperty(@PathVariable("id") Integer propertyId) {
    log.info("Finding property: {}", propertyId);
    return propertyService.findProperty(propertyId);
  }


}
