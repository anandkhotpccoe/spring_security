package com.sharetocare.prototype.controller;


import com.sharetocare.prototype.controller.utils.Response;
import com.sharetocare.prototype.model.Item;
import com.sharetocare.prototype.respository.ItemRepository;
import com.sharetocare.prototype.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category/{categoryId}/subcategory")
public class ItemController {


    @Autowired
    private static final Logger log = LoggerFactory.getLogger(SubCategoryController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/{subcategoryId}/item")
    public ResponseEntity<Response> getItemBySubCategoryId(@PathVariable Long subcategoryId)
    {
        Iterable<Item> result = itemService.getItemBySubCategoryId(subcategoryId);
        long size = result.spliterator().getExactSizeIfKnown();
        log.info("Size {}: ",size);
        if (size == 0)
        {
            return new ResponseEntity<>(Response.error(600,"No Item Found"),HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(Response.success(result), HttpStatus.OK);
    }


    @GetMapping("/{subcategoryId}/item/{id}")
    public ResponseEntity<Response> get(@PathVariable Long id)
    {
        if (!itemRepository.existsById(id))
        {
            return new ResponseEntity<>(Response.error(600,"No Item Found"),HttpStatus.NOT_FOUND);

        }
        return  new ResponseEntity<>(Response.success(itemService.get(id)),HttpStatus.OK);

    }

    @DeleteMapping("/{subcategoryId}/item/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id)
    {
        if (!itemRepository.existsById(id))
        {
            return new ResponseEntity<>(Response.error(600,"No Item Found"),HttpStatus.NOT_FOUND);

        }
        itemService.delete(id);
        return  new ResponseEntity<>(Response.success(),HttpStatus.OK);

    }


    @PostMapping("/{subcategoryId}/item")
    public ResponseEntity<Response> add(@RequestBody Item item, @PathVariable Long subcategoryId)
    {
        Item result = itemService.add(item,subcategoryId);
        return  new ResponseEntity<>(Response.success(result),HttpStatus.CREATED);
    }


    @PutMapping("/{subcategoryId}/item/{id}")
    public ResponseEntity<Response> update(@RequestBody Item item, @PathVariable Long id)
    {
        if (!itemRepository.existsById(id))
        {
            return new ResponseEntity<>(Response.error(600,"No Item Found"),HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(Response.success(itemService.update(item)),HttpStatus.OK);
    }


    @GetMapping("/{subcategoryId}/item/search/{name}")
    public ResponseEntity<Response> searchBySubCategoryAndName(@PathVariable Long subcategoryId, @PathVariable String name)
    {
        List<Item> result = itemRepository.findBySubCategoryIdAndNameContaining(subcategoryId,name);
        if (result.isEmpty())
        {
            return  new ResponseEntity<>(Response.error(801,"No SubCategory Found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Response.success(result),HttpStatus.OK);
    }

    @GetMapping("/item/search/{name}")
    public ResponseEntity<Response> searchByName(@PathVariable String name)
    {
        List<Item> result = itemRepository.findByNameContaining(name);
        if (result.isEmpty())
        {
            return  new ResponseEntity<>(Response.error(801,"No SubCategory Found"),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Response.success(result),HttpStatus.OK);
    }

}
