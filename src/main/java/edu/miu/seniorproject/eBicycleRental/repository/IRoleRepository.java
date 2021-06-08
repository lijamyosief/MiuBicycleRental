package edu.miu.seniorproject.eBicycleRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.seniorproject.eBicycleRental.model.Role;

@Repository("roleRepository")
public interface IRoleRepository extends JpaRepository<Role, Long> {
}
