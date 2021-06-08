package edu.miu.seniorproject.eBicycleRental.repository;

import edu.miu.seniorproject.eBicycleRental.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
