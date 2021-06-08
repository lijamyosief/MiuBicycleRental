package edu.miu.seniorproject.eBicycleRental.service;

import java.util.List;

import edu.miu.seniorproject.eBicycleRental.model.Vehicle;

public interface VehicleService {

    List<Vehicle> findAll();
    Vehicle save(Vehicle vehicle);
    Vehicle findById(Long vId);
    void delete(Long vehicleId);
    String assignVehicleNumber();

}
