package com.levinine.codenine.bookingcompleted.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "property")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Property {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String address;

  private String contactPhone;

  @OneToMany(mappedBy="property", cascade = CascadeType.ALL)
  private List<Room> rooms;

}
