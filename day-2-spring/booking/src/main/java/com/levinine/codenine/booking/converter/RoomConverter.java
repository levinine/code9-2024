package com.levinine.codenine.booking.converter;

import com.levinine.codenine.booking.dto.RoomDto;
import com.levinine.codenine.booking.model.Property;
import com.levinine.codenine.booking.model.Room;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class RoomConverter {

  public RoomDto toDto(Room room) {
    return RoomDto.builder()
        .id(room.getId())
        .propertyId(room.getProperty().getId())
        .roomNumber(room.getRoomNumber())
        .price(room.getPrice())
        .status(room.getStatus())
        .build();
  }

  public Room toEntity(RoomDto room, Property property) {
    return Room.builder()
        .roomNumber(room.getRoomNumber())
        .price(room.getPrice())
        .status(room.getStatus())
        .property(property)
        .build();
  }

  public List<RoomDto> toDtoList(List<Room> rooms) {
    return rooms.stream()
        .map(this::toDto)
        .toList();
  }

  public List<Room> toEntityList(List<RoomDto> rooms, Property property) {
    return rooms.stream()
        .map(roomDto -> toEntity(roomDto, property))
        .toList();
  }

}
