package edu.miu.seniorproject.eBicycleRental.service;

import java.time.LocalDate;
import java.util.List;

import edu.miu.seniorproject.eBicycleRental.model.Category;
import edu.miu.seniorproject.eBicycleRental.model.Vehicle;

public interface SearchService {
	
	List<Category> findAvailableCategories(LocalDate start, LocalDate end);
	List<Vehicle> getAvailableVehicles(LocalDate start, LocalDate end);


}
