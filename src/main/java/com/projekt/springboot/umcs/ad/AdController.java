package com.projekt.springboot.umcs.ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/ads")
public class AdController {

    private final com.projekt.springboot.umcs.ad.AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public List<Ad> getAds() {
        return adService.getAds();
    }

    @PostMapping
    public void addNewAd(@RequestBody Ad ad) {
        adService.addNewAd(ad);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAd(@PathVariable("AdId") Long AdId) {
        adService.deleteAd(AdId);
    }

    @PutMapping(path = "{id}")
    public void updateAd(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        adService.updateAd(id, name, email);
    }
}
