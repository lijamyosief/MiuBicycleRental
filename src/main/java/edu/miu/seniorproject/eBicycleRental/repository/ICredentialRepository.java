package edu.miu.seniorproject.eBicycleRental.repository;

import edu.miu.seniorproject.eBicycleRental.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("credentialRepository")
public interface ICredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> findByUserName(String username);

}
