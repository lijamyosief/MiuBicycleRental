package edu.miu.seniorproject.eBicycleRental.repository;

import edu.miu.seniorproject.eBicycleRental.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookingRepository")
public interface IBookingRepository extends JpaRepository<Booking, Long> {
@Query("SELECT b FROM Booking b order by b.bookingDate desc")
    List<Booking> findAllOrderByDate();
}
