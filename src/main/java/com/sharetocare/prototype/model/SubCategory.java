package com.sharetocare.prototype.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharetocare.prototype.model.audit.DateAudit;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubCategory extends DateAudit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;


    private String name;


    @OneToOne
    @JsonIgnore
    @JoinColumn(updatable = false)
    private Category category;


    @OneToMany
    @JsonIgnore
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
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

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", items=" + items +
                '}';
    }
}
