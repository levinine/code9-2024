package com.levinine.codenine.bookingcompleted.service;

import com.levinine.codenine.bookingcompleted.converter.PropertyConverter;
import com.levinine.codenine.bookingcompleted.dto.PropertyDto;
import com.levinine.codenine.bookingcompleted.model.Property;
import com.levinine.codenine.bookingcompleted.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PropertyService {

  private final PropertyRepository propertyRepository;
  private final PropertyConverter propertyConverter;

  public PropertyDto saveProperty(PropertyDto propertyDto) {
    Property property = propertyRepository.save(propertyConverter.toEntity(propertyDto));
    log.info("Saved new property: {}", property.getName());
    return propertyConverter.toDto(property);
  }

  public List<PropertyDto> findAllProperties() {
    List<Property> properties = propertyRepository.findAll();
    log.info("All properties returned from database");
    return propertyConverter.toDtoList(properties);
  }
}
