package com.sharetocare.prototype.respository;

import com.sharetocare.prototype.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {

    public Iterable<Item> findBySubCategoryId(Long subcategoryId);


    public List<Item> findBySubCategoryIdAndNameContaining(Long categoryId, String name);

    public List<Item> findByNameContaining(String name);
}
