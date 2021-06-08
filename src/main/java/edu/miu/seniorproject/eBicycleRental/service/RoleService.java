package edu.miu.seniorproject.eBicycleRental.service;

import java.util.List;

import edu.miu.seniorproject.eBicycleRental.model.Role;

public interface RoleService {
    List<Role> findAll();
    Role save(Role role);
    Role findById(Long rId);
    void delete(Long rId);
}
