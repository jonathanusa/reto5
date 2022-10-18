package com.example.demo.repositories.crudRepositories;

import com.example.demo.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
