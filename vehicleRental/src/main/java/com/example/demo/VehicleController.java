package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/displayVehicles")
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    }

}
