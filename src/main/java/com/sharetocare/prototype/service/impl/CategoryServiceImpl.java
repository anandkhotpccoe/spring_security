package com.sharetocare.prototype.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharetocare.prototype.exception.CategoryFetchException;
import com.sharetocare.prototype.model.Category;
import com.sharetocare.prototype.respository.CategoryRepository;
import com.sharetocare.prototype.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Iterable<Category> getAll()
	{
		Iterable<Category> result = categoryRepository.findAll();
        return result;
	}
	
	
	public Category add(Category category)
	{
		return categoryRepository.save(category);
	}
	
	
	public Category update(Category category)
	{
		return categoryRepository.save(category);
	}
	
	public Category get(Long id)
	{
		
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
			
		}
		else {
			throw new CategoryFetchException("Problem in Fetching Category ID: " + id);
		}
		
	}
	
	public void delete(Long id)
	{
		categoryRepository.deleteById(id);
	}
	
	

}
