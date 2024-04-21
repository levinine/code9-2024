package com.levinine.codenine.booking.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
