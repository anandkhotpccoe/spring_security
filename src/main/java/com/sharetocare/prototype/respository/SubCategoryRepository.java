package com.sharetocare.prototype.respository;

import com.sharetocare.prototype.model.Item;
import com.sharetocare.prototype.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {

    public Iterable<SubCategory> findByCategoryId(Long categoryId);


    public List<SubCategory> findByCategoryIdAndNameContaining(Long categoryId,String name);
}
