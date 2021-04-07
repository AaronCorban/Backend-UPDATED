package com.takeaway.demo.dao;

import com.takeaway.demo.entity.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "dishCategory", path = "dish-category")
// collection Resource Rel will be the name of the JSON entry, path then is /dish-category
public interface DishCategoryRepository extends JpaRepository<DishCategory, Long> {
}
