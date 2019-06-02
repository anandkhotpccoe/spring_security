package com.sharetocare.prototype.service;

import com.sharetocare.prototype.model.Item;
import com.sharetocare.prototype.model.SubCategory;

public interface SubCategoryService {


    public Iterable<SubCategory> getAll();

    public SubCategory add(SubCategory item, Long categoryId);

    public SubCategory update(SubCategory subCategory);

    public SubCategory get(Long id);

    public void delete(Long id);


    public Iterable<SubCategory> getSubCategoryByCategoryId(Long categoryId);
}
