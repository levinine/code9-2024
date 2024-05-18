package com.levinine.codenine.bookingcompleted.repository;

import com.levinine.codenine.bookingcompleted.model.Room;
import com.levinine.codenine.bookingcompleted.model.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Optional<Room> findByIdAndStatus(Integer roomId, RoomStatus status);

}
