package com.levinine.codenine.booking.controller;

import com.levinine.codenine.booking.dto.PropertyDto;
import com.levinine.codenine.booking.service.PropertyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

}
