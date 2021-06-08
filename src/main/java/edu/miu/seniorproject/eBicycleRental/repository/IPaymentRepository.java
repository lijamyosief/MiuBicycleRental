package edu.miu.seniorproject.eBicycleRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.miu.seniorproject.eBicycleRental.model.Payment;

@Repository("paymentRepository")
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
}
