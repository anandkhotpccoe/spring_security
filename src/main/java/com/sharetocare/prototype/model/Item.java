package com.sharetocare.prototype.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sharetocare.prototype.model.audit.DateAudit;

import javax.persistence.*;

@Entity
public class Item extends DateAudit {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private  String name;

    @JsonIgnore
    @OneToOne
    @JoinColumn(updatable = false)
    SubCategory subCategory;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
