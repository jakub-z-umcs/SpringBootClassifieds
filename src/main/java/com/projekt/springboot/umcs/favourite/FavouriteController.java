package com.projekt.springboot.umcs.favourite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/categories")
public class FavouriteController {

    private final FavouriteService favouriteService;

    @Autowired
    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @GetMapping
    public List<Favourite> getAll() {
        return favouriteService.getAll();
    }

    @GetMapping(path = "{id}")
    public Favourite getOne(@PathVariable("id") Long id) {
        return favouriteService.getOne(id);
    }
}
