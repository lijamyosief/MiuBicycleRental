package edu.miu.seniorproject.eBicycleRental.service;

import java.util.List;

import edu.miu.seniorproject.eBicycleRental.model.Category;

public interface CategoryService {

    List<Category> findAll();
    Category save(Category category);
    Category findById(Long cId);
    void delete(Long cId);

}
