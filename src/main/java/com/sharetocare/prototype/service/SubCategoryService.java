package com.sharetocare.prototype.service;

import com.sharetocare.prototype.model.Item;
import com.sharetocare.prototype.model.SubCategory;

public interface SubCategoryService {


    public Iterable<SubCategory> getAll();

    public SubCategory add(SubCategory item);

    public SubCategory update(SubCategory item);

    public SubCategory get(Long id);

    public void delete(Long id);


    public Iterable<SubCategory> getSubCategoryByCategoryId(Long categoryId);
}
