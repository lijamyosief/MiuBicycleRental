package edu.miu.seniorproject.eBicycleRental.serviceimplementation;

import edu.miu.seniorproject.eBicycleRental.model.Category;
import edu.miu.seniorproject.eBicycleRental.repository.ICategoryRepository;
import edu.miu.seniorproject.eBicycleRental.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImp implements CategoryService {
	
	private ICategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImp(ICategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category findById(Long cId) {
		return categoryRepository.findById(cId).orElse(null);
	}

	@Override
	public void delete(Long cId) {
		categoryRepository.deleteById(cId);
	}

}
