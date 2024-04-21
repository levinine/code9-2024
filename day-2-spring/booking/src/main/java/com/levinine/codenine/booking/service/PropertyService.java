package com.levinine.codenine.booking.service;

import com.levinine.codenine.booking.converter.PropertyConverter;
import com.levinine.codenine.booking.dto.PropertyDto;
import com.levinine.codenine.booking.model.Property;
import com.levinine.codenine.booking.repository.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

  public PropertyDto findProperty(Integer propertyId) {
    Property property = propertyRepository.findById(propertyId).orElseThrow(
        () -> new EntityNotFoundException(
            String.format("Property with id: %s not found", propertyId)));
    return propertyConverter.toDto(property);
  }

}
