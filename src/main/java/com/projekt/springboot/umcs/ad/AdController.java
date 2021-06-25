package com.projekt.springboot.umcs.ad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projekt.springboot.umcs.user.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/ads")
public class AdController {

    private final AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public List<Ad> getAds() {
        return adService.getAds();
    }

    @GetMapping(path = "{id}")
    public Ad getAd(@PathVariable("id") Long AdId) {
        return adService.getAd(AdId);
    }

    @PostMapping
    public void addNewAd(@RequestBody Ad ad) {
        adService.addNewAd(ad);
    }

    @DeleteMapping(path = "{id}")
    public void deleteAd(@PathVariable("id") Long AdId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails.getId() == adService.getAd(AdId).getUserId()) {
            adService.deleteAd(AdId);
        }
    }

    @PatchMapping(path = "{id}")
    public void updateAd(
            @PathVariable("id") Long id,
            @RequestParam(required = true) String title,
            @RequestParam(required = true) String description,
            @RequestParam(required = true) int priceInCents) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userDetails.getId() == adService.getAd(id).getUserId()) {
            adService.updateAd(id, title, description, priceInCents);
        }

    }
}
