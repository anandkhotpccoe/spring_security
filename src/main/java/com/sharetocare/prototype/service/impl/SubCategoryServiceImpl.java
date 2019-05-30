package com.sharetocare.prototype.service.impl;

import com.sharetocare.prototype.exception.CategoryFetchException;
import com.sharetocare.prototype.model.Item;
import com.sharetocare.prototype.model.SubCategory;
import com.sharetocare.prototype.respository.SubCategoryRepository;
import com.sharetocare.prototype.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;


    @Override
    public Iterable<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory add(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory update(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory get(Long id) {
        Optional<SubCategory> subCategory = subCategoryRepository.findById(id);
        if (subCategory.isPresent()) {
            return subCategory.get();

        }
        else {
            throw new CategoryFetchException("Problem in Fetching Category ID: " + id);
        }

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Iterable<SubCategory> getSubCategoryByCategoryId(Long categoryId) {




        return subCategoryRepository.findByCategoryId(categoryId);
    }
}
