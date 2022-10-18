package com.example.demo.repositories.crudRepositories;


import com.example.demo.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer>{
    
}
