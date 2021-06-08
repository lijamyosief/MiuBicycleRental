package edu.miu.seniorproject.eBicycleRental.repository;

import edu.miu.seniorproject.eBicycleRental.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.seniorproject.eBicycleRental.model.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long> {
    //    User findByUserName(String username);
//    user findBy
    User findByCredential(Credential credential);
}
