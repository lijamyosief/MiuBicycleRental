package edu.miu.seniorproject.eBicycleRental.service;

import edu.miu.seniorproject.eBicycleRental.model.Booking;

import java.util.List;


public interface BookingService {
    List<Booking> findAll();
    Booking save(Booking booking);
    Booking findById(Long bId);
    void delete(Long bId);
    String assignReferenceNumber();
    List<Booking> findAllOrderByDate();
}
