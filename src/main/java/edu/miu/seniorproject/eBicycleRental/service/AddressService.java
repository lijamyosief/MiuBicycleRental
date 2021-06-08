package edu.miu.seniorproject.eBicycleRental.service;

import java.util.List;

import edu.miu.seniorproject.eBicycleRental.model.Address;

public interface AddressService {
    List<Address> findAll();
    Address save(Address address);
    Address findById(Long aId);
    void delete(Long aId);
}
