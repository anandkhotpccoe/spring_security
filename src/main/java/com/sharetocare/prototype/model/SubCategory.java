package com.sharetocare.prototype.model;

import com.sharetocare.prototype.model.audit.DateAudit;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class SubCategory extends DateAudit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;


    private String name;


    @OneToOne
    private Category category;


    @OneToMany
    private Set<Item> items = new HashSet<>();


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
