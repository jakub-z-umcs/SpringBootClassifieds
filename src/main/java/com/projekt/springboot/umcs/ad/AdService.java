package com.projekt.springboot.umcs.ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AdService {

    private final com.projekt.springboot.umcs.ad.AdRepository adRepository;

    @Autowired
    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public List<Ad> getAds() {
        return adRepository.findAll();
    }

    public void addNewAd(Ad ad) {
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
    public void updateAd(Long AdId, String name) {
        Ad ad = adRepository.findById(AdId).orElseThrow(() -> new IllegalStateException(
                "Ad with id " + AdId + " does not exist"));

        if (name != null && !Objects.equals(ad.getName(), name)) {
            ad.setName(name);
        }
    }
}

