package edu.miu.seniorproject.eBicycleRental.service;

import java.util.List;

import edu.miu.seniorproject.eBicycleRental.model.Credential;

public interface CredentialService {
    List<Credential> findAll();
    Credential save(Credential credential);
    Credential findById(Long cId);
    void delete(Long cId);

    Credential findByUserName(String name);
}
