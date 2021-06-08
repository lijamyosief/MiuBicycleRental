package edu.miu.seniorproject.eBicycleRental.serviceimplementation;

import edu.miu.seniorproject.eBicycleRental.model.Payment;
import edu.miu.seniorproject.eBicycleRental.repository.IPaymentRepository;
import edu.miu.seniorproject.eBicycleRental.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("paymentService")
@Transactional
public class PaymentServiceImp implements PaymentService {
	
	private IPaymentRepository paymentRepository;
	
	@Autowired
	public PaymentServiceImp(IPaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		System.out.println(payment.getCardCVV());
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findById(Long paymentId) {
		return paymentRepository.findById(paymentId).orElse(null);
	}

	@Override
	public void delete(Long pId) {
		paymentRepository.deleteById(pId);
		
	}

	@Override
	public Double getTotalPrice(Payment payment) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public String count() {
		// TODO Auto-generated method stub
		return null;
	}
}

	
