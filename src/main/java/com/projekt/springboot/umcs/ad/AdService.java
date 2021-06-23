package com.projekt.springboot.umcs.ad;

import com.projekt.springboot.umcs.user.MyUserDetails;
import com.projekt.springboot.umcs.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdService {

    private final AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public List<Ad> getAds() {
        return adRepository.findAll();
    }

    public Ad getAd(Long AdId) {
        return adRepository.getById(AdId);
    }

    public void addNewAd(Ad ad) {
        MyUserDetails user = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("#######");
        System.out.println(user);
        ad.setUserId(user.getId());
        adRepository.save(ad);
    }

    public void deleteAd(Long AdId) {
        boolean exists = adRepository.existsById(AdId);
        if (!exists) {
            throw new IllegalStateException(
                    "Ad with id " + AdId + " does not exists.");
        }
        adRepository.deleteById(AdId);

    }

    @Transactional
    public void updateAd(Long id, String title) {
        Ad ad = adRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                "Ad with id " + id + " does not exist"));

        ad.setTitle(title);
    }
}

