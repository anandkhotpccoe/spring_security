/**
 * 
 */
package com.sharetocare.prototype.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sharetocare.prototype.model.Category;

/**
 * @author anand
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	
	List<Category> findByName(String name);

}
