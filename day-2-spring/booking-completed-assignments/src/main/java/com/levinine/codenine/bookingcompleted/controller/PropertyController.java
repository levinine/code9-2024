package com.levinine.codenine.bookingcompleted.controller;

import com.levinine.codenine.bookingcompleted.dto.PropertyDto;
import com.levinine.codenine.bookingcompleted.service.PropertyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@AllArgsConstructor
@Slf4j
@Validated
public class PropertyController {

    private final PropertyService propertyService;

    @PostMapping
    public PropertyDto createProperty(@Valid @RequestBody PropertyDto propertyDto) {
        log.info("Saving new property: {}", propertyDto.getName());
        return propertyService.saveProperty(propertyDto);
    }

    @GetMapping
    public List<PropertyDto> findAllProperties() {
        log.info("Finding all properties");
        return propertyService.findAllProperties();
    }

}
