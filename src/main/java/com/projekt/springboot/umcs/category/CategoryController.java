package com.projekt.springboot.umcs.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping(path = "{id}")
    public Category getOne(@PathVariable("id") Long id) {
        return categoryService.getOne(id);
    }

    @PostMapping
    public void addNew(@RequestBody Category category) {
        categoryService.addNew(category);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        categoryService.delete(id);
    }

    @PatchMapping(path = "{id}")
    public void update(
            @PathVariable("id") Long id,
            @RequestParam(required = true) String name) {
        categoryService.update(id, name);
    }
}
