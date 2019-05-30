package com.sharetocare.prototype.controller;


import com.sharetocare.prototype.controller.utils.Response;
import com.sharetocare.prototype.model.Item;
import com.sharetocare.prototype.model.SubCategory;
import com.sharetocare.prototype.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class SubCategoryController {


    @Autowired
    SubCategoryService subCategoryService;


    @GetMapping("/{categoryId}/subcategory")
    public ResponseEntity<Response> getSubCategoryByCategoryId(@PathVariable Long categoryId)
    {
        Iterable<SubCategory> result = subCategoryService.getSubCategoryByCategoryId(categoryId);
        return  new ResponseEntity<>(Response.success(result),HttpStatus.OK);
    }


}
