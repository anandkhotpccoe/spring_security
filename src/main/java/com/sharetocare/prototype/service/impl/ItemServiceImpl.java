package com.sharetocare.prototype.service.impl;

import com.sharetocare.prototype.model.Item;
import com.sharetocare.prototype.respository.ItemRepository;
import com.sharetocare.prototype.respository.SubCategoryRepository;
import com.sharetocare.prototype.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;


    @Autowired
    SubCategoryRepository subCategoryRepository;


    @Override
    public Iterable<Item> getAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item add(Item item, Long subcategoryId) {

        item.setSubCategory(subCategoryRepository.getOne(subcategoryId));
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item get(Long id) {
        return itemRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);

    }

    @Override
    public Iterable<Item> getItemBySubCategoryId(Long subcategoryId) {
        return itemRepository.findBySubCategoryId(subcategoryId);
    }
}
