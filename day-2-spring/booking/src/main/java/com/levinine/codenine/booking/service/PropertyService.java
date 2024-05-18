package com.levinine.codenine.booking.service;

import com.levinine.codenine.booking.converter.PropertyConverter;
import com.levinine.codenine.booking.dto.PropertyDto;
import com.levinine.codenine.booking.model.Property;
import com.levinine.codenine.booking.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PropertyService {


  /**
   *
   *    Napravljen je novi repository sa svim resenim zadacima
   *      zadaci se nalaze u resources/assignments
   *      za treci zadatak imate request koji trebate poslati u postman body -> u resources/requests
   *    koristite ovaj projekat za resavanje zadataka, pa uporedite vasa resenja sa nasim
   *    Note: nije moranje da resenja budu ista, bitno je samo da rade
   *
   * */

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
