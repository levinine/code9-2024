package com.levinine.codenine.booking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.levinine.codenine.booking.converter.PropertyConverter;
import com.levinine.codenine.booking.converter.RoomConverter;
import com.levinine.codenine.booking.dto.PropertyDto;
import com.levinine.codenine.booking.dto.RoomDto;
import com.levinine.codenine.booking.model.Property;
import com.levinine.codenine.booking.model.Room;
import com.levinine.codenine.booking.repository.PropertyRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

  private static final Integer PROPERTY_ID = 1;

  @Mock
  private PropertyRepository propertyRepository;

  private final PropertyConverter propertyConverter =
      spy(new PropertyConverter(spy(new RoomConverter())));

  @InjectMocks
  private PropertyService propertyService;

  @Test
  void shouldCreateProperty() {
    // Given
    Property property = buildProperty();
    PropertyDto propertyDto = buildPropertyDto();
    when(propertyRepository.save(any())).thenReturn(property);

    // When
    PropertyDto savedProperty = propertyService.saveProperty(propertyDto);

    // Then
    assertNotNull(savedProperty.getId());
    assertEquals(1, property.getId());
  }

  private PropertyDto buildPropertyDto() {
    return PropertyDto.builder()
        .name("Laguna Hotel")
        .address("Main Lane 22A")
        .contactPhone("89-45-34")
        .rooms(List.of(RoomDto.builder()
            .roomNumber(1)
            .price(100.00)
            .status("AVAILABLE")
            .build()))
        .build();
  }

  private Property buildProperty() {
    final Property property = Property.builder()
        .id(PROPERTY_ID)
        .name("Laguna Hotel")
        .address("Main Lane 22A")
        .contactPhone("89-45-34")
        .build();
    property.setRooms(List.of(Room.builder()
        .property(property)
        .roomNumber(1)
        .price(100.00)
        .status("AVAILABLE")
        .build()));
    return property;
  }

}
