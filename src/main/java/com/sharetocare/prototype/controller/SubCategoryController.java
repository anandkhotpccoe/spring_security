package com.sharetocare.prototype.controller;


import com.sharetocare.prototype.controller.utils.Response;
import com.sharetocare.prototype.model.SubCategory;
import com.sharetocare.prototype.respository.SubCategoryRepository;
import com.sharetocare.prototype.service.SubCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class SubCategoryController {


    @Autowired
    private static final Logger log = LoggerFactory.getLogger(SubCategoryController.class);
    @Autowired
    SubCategoryService subCategoryService;



    @Autowired
    SubCategoryRepository subCategoryRepository;


    @GetMapping("/{categoryId}/subcategory")
    public ResponseEntity<Response> getSubCategoryByCategoryId(@PathVariable Long categoryId)
    {
        Iterable<SubCategory> result = subCategoryService.getSubCategoryByCategoryId(categoryId);
        return  new ResponseEntity<>(Response.success(result),HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/subcategory/{id}")
    public  ResponseEntity<Response> get(@PathVariable Long id)
    {
        if (subCategoryRepository.existsById(id)) {
            SubCategory subCategory = subCategoryService.get(id);
            return new ResponseEntity<>(Response.success(subCategory), HttpStatus.OK);
        }
        else
        {
            log.info("Sub Category With Specified Identity Does Not Exists");
            return new ResponseEntity<>(Response.error(504,"Sub Category With Specified Identity Does Not Exists"),HttpStatus.NOT_FOUND);

        }


    }

    @PostMapping("/{categoryId}/subcategory")
    public ResponseEntity<Response> add(@RequestBody SubCategory subCategory, @PathVariable Long categoryId)
    {
        SubCategory result = subCategoryService.add(subCategory, categoryId);
        return  new ResponseEntity<>(Response.success(result),HttpStatus.OK);
    }



    @PutMapping("/{categoryId}/subcategory/{id}")
    public ResponseEntity<Response> update(@RequestBody SubCategory subCategory, @PathVariable Long id)
    {
            boolean isPresent = subCategoryRepository.existsById(id);

            log.info("Subcategory {}", isPresent);
            if (subCategoryRepository.existsById(id))
            {
                SubCategory result = subCategoryService.update(subCategory);
                return  new ResponseEntity<>(Response.success(result),HttpStatus.OK);
            }
             else
            {

                return new ResponseEntity<>(Response.error(504,"Sub Category With Specified Identity Does Not Exists"),HttpStatus.NOT_FOUND);

            }

    }



    @DeleteMapping("/category/{categoryId}/subcategory/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id)
    {
        if (subCategoryRepository.existsById(id))
        {
            try {
                subCategoryService.delete(id);
                return  new ResponseEntity<>(Response.success(),HttpStatus.OK);
            }
            catch (Exception e)
            {
                log.info("Something Went Wrong While Deleting Sub Category");
                return new ResponseEntity<>(Response.error(504,"Exception Occurred "),HttpStatus.NOT_FOUND);
            }
        }
        else
        {

            return new ResponseEntity<>(Response.error(504,"Sub Category With Specified Identity Does Not Exists"),HttpStatus.NOT_FOUND);

        }


    }


    @GetMapping("/category/{categoryId}/category/{name}")
    public ResponseEntity<Response> searchByName(@PathVariable Long categoryId, @PathVariable String name)
    {
        List<SubCategory> result = subCategoryRepository.findByCategoryIdAndNameContaining(categoryId,name);
        if (result.isEmpty())
        {
            return  new ResponseEntity<>(Response.error(801,"No SubCategory Found"),HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(Response.success(result),HttpStatus.OK);
        }
    }





}
