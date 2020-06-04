package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString

@Document(collection="VehicleCollection")
public class Vehicle {
    @Id
    String plateNo;
    String model;
    String make;
    String capacity;
    String noOfSeats;
    String airConditioner;
}
