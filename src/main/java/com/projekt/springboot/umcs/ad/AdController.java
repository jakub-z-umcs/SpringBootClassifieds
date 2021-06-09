package com.projekt.springboot.umcs.ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/students")
public class AdController {

    private final com.projekt.springboot.umcs.ad.AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public List<Ad> getStudents() {
        return adService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Ad ad) {
        adService.addNewStudent(ad);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        adService.deleteStudent(studentId);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        adService.updateStudent(studentId, name, email);
    }
}
