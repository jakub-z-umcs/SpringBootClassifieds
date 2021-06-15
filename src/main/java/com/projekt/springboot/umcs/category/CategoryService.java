package com.projekt.springboot.umcs.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getOne(Long id) {
        return categoryRepository.getById(id);
    }

    public void addNew(Category category) {
        categoryRepository.save(category);
    }

    public void delete(Long id) {
        boolean exists = categoryRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException(
                    "Ad with id " + id + " does not exists.");
        }
        categoryRepository.deleteById(id);

    }

    @Transactional
    public void update(Long id, String name) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Ad with id " + id + " does not exist"));

        category.setName(name);
    }
}

