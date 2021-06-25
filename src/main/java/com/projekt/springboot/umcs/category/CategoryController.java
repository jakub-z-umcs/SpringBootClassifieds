package com.projekt.springboot.umcs.category;

import com.projekt.springboot.umcs.ad.Ad;
import com.projekt.springboot.umcs.ad.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final AdService adService;

    @Autowired
    public CategoryController(CategoryService categoryService, AdService adService) {
        this.categoryService = categoryService;
        this.adService = adService;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping(path = "{id}")
    public List<Ad> getAllAdsByCategory(@PathVariable("id") Long id) {
        return adService.getAllByCategoryId(id);
    }
}
