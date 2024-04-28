package com.levinine.codenine.booking.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.levinine.codenine.booking.dto.PropertyDto;
import com.levinine.codenine.booking.dto.RoomDto;
import com.levinine.codenine.booking.service.PropertyService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(PropertyController.class)
class PropertyControllerTest {

  private static final Integer PROPERTY_ID = 1;

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PropertyService propertyService;

  @Test
  void shouldCreateProperty() throws Exception {
    PropertyDto property = buildPropertyDto();
    when(propertyService.saveProperty(any(PropertyDto.class))).thenReturn(property);

    mockMvc.perform(MockMvcRequestBuilders.post("/properties")
        .contentType(MediaType.APPLICATION_JSON)
        .content(createPropertyRequest()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());

    verify(propertyService, times(1)).saveProperty(any(PropertyDto.class));
  }

  private String createPropertyRequest() {
    return """
        {
            "name": "Blue Horizon Apartments",
            "address": "Sunset Boulevard 34",
            "contactPhone": "345-433-023",
            "rooms" : [
                {
                    "roomNumber": 601,
                    "price": 234,
                    "status": "AVAILABLE"
                }
            ]
        }
        """;
  }

  private PropertyDto buildPropertyDto() {
    return PropertyDto.builder()
        .id(PROPERTY_ID)
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

}
