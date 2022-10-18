package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Retorna todos los elementos de la tabla category
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    // Retorna un elemento que refiera al identificador id de la tabla category
    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    // Guarda un elemento en la tabla category
    public Category save(Category category) {

        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> b = categoryRepository.getCategory(category.getId());
            if (b.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    // Actualiza un elemento en la tabla category
    public Category update(Category category) {

        if (category.getId() != null) {

            Optional<Category> b = categoryRepository.getCategory(category.getId());

            if (!b.isEmpty()) {

                // Se retornan los atributos en caso de que sean no nulos
                if (category.getName() != null) {
                    b.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    b.get().setDescription(category.getDescription());
                }

                // Se realiza la actualización del objeto con ayuda del repositorio
                categoryRepository.save(b.get());
                return b.get();
            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    // Elimina un elemento en la tabla category
    public boolean deleteCategory(int id) {

        Boolean bBoolean = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);

        return bBoolean;
    }

}
