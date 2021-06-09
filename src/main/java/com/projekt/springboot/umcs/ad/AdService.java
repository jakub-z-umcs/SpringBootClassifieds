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

    public List<Ad> getStudents() {
        return adRepository.findAll();
    }

    public void addNewStudent(Ad ad) {
        Optional<Ad> studentOptional = adRepository.findStudentByEmail(ad.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        adRepository.save(ad);
        System.out.println(ad);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = adRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + " does not exists.");
        }
        adRepository.deleteById(studentId);

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Ad ad = adRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "student with id " + studentId + " does not exist"));

        if (name != null && !Objects.equals(ad.getName(), name)) {
            ad.setName(name);
        }
        ad.setEmail(email);
    }
}

