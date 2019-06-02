package com.sharetocare.prototype.service;

import com.sharetocare.prototype.model.Item;

public interface ItemService {


    public Iterable<Item> getAll();

    public Item add(Item item, Long subcategoryId);

    public Item update(Item item);

    public Item get(Long id);

    public void delete(Long id);


    public Iterable<Item> getItemBySubCategoryId(Long subcategoryId);
}
