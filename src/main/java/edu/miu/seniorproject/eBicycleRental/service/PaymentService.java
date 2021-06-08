package edu.miu.seniorproject.eBicycleRental.service;

import java.util.List;

import edu.miu.seniorproject.eBicycleRental.model.Payment;

public interface PaymentService {

    List<Payment> findAll();
    Payment save(Payment payment);
    Payment findById(Long paymentId);
    void delete(Long paymentId);
    String count();
    Double getTotalPrice(Payment payment);
}
