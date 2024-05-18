package com.levinine.codenine.bookingcompleted.converter;

import com.levinine.codenine.bookingcompleted.dto.PropertyDto;
import com.levinine.codenine.bookingcompleted.model.Property;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyConverter {

  private final RoomConverter roomConverter;

  public PropertyDto toDto(Property property) {
    return PropertyDto.builder()
        .id(property.getId())
        .name(property.getName())
        .address(property.getAddress())
        .contactPhone(property.getContactPhone())
        .rooms(roomConverter.toDtoList(property.getRooms()))
        .build();
  }

  public Property toEntity(PropertyDto propertyDto) {
    Property property =  Property.builder()
        .name(propertyDto.getName())
        .address(propertyDto.getAddress())
        .contactPhone(propertyDto.getContactPhone())
        .build();
    property.setRooms(roomConverter.toEntityList(propertyDto.getRooms(), property));
    return property;
  }

  public List<PropertyDto> toDtoList(List<Property> properties) {
    return properties.stream()
        .map(this::toDto)
        .toList();
  }

}
