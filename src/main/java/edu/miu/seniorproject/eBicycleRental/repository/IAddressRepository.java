package edu.miu.seniorproject.eBicycleRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.seniorproject.eBicycleRental.model.Address;

@Repository("addressRepository")
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
