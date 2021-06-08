package edu.miu.seniorproject.eBicycleRental.serviceimplementation;

import edu.miu.seniorproject.eBicycleRental.model.Booking;
import edu.miu.seniorproject.eBicycleRental.repository.IBookingRepository;
import edu.miu.seniorproject.eBicycleRental.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookingService")
public class BookingServiceImp implements BookingService {
	
	private IBookingRepository bookingRepository;
	
	@Autowired
	public BookingServiceImp(IBookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Booking findById(Long bId) {
		return bookingRepository.findById(bId).orElse(null);
	}

	@Override
	public void delete(Long bId) {
		System.out.println("Id++:"+bId);
		bookingRepository.deleteById(bId);
		bookingRepository.flush();
	}

	@Override
	public String assignReferenceNumber() {
		if(bookingRepository.findAll().stream().count() == 0) return "BN1";
		Long currentId = bookingRepository.findAll().stream().mapToLong(Booking::getBookingId).max().getAsLong();
		return  "BN" + (currentId + 1) ;
	}

//	@Override
//	public List<Booking> findAllOrderByDate() {
//		return null;
//	}

	@Override
	public List<Booking> findAllOrderByDate() {
		return bookingRepository.findAllOrderByDate();
	}

}
	