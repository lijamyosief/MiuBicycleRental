package edu.miu.seniorproject.eBicycleRental.service;

import java.util.List;

import edu.miu.seniorproject.eBicycleRental.model.Credential;
import edu.miu.seniorproject.eBicycleRental.model.User;

public interface UserService {

    List<User> findAll();
    User save(User user);
    User findById(Long uId);
    void delete(Long uId);

    User findByCredential(Credential credential);
}
