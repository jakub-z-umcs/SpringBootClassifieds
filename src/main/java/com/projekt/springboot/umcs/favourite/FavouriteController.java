package com.projekt.springboot.umcs.favourite;

import com.projekt.springboot.umcs.UserRepository;
import com.projekt.springboot.umcs.ad.Ad;
import com.projekt.springboot.umcs.ad.AdRepository;
import com.projekt.springboot.umcs.ad.AdService;
import com.projekt.springboot.umcs.user.MyUserDetails;
import com.projekt.springboot.umcs.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(path="api/v1/favourites")
public class FavouriteController {

    private final AdService adService;
    private final UserRepository userRepository;
    private final AdRepository adRepository;


    @Autowired
    public FavouriteController(AdService adService, UserRepository userRepository, AdRepository adRepository) {
        this.adService = adService;
        this.userRepository = userRepository;
        this.adRepository = adRepository;
    }



    @GetMapping
    public Set<Ad> getAll() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(userDetails.getId()).orElse(null);
        if(user != null) {
            return user.getFavourites();
        }
        return new HashSet<Ad>();
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long adId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(userDetails.getId()).orElse(null);
        Ad ad = adService.getAd(adId);
        ad.getLikedBy().remove(user);
        adRepository.save(ad);
    }

    @PostMapping
    public void addNewFavourite(@RequestParam(required = true) Long adId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findById(userDetails.getId()).orElse(null);
        Ad ad = adService.getAd(adId);
        ad.getLikedBy().add(user);
        adRepository.save(ad);
    }
}
