package edu.miu.seniorproject.eBicycleRental.repository;

import edu.miu.seniorproject.eBicycleRental.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehicleRepository")
public interface IVehicleRepository extends JpaRepository<Vehicle, Long> {
}
