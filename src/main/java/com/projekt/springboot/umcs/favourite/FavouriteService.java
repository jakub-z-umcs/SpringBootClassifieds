//package com.projekt.springboot.umcs.favourite;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//public class FavouriteService {
//
//    public FavouriteService() {
//    }
//
//    public void FavouriteNew(Long adId) {
//        favouriteRepository.save(adId);
//    }
//
//    public void delete(Long id) {
//        boolean exists = favouriteRepository.existsById(id);
//        if (!exists) {
//            throw new IllegalStateException(
//                    "Favourite with id " + id + " does not exists.");
//        }
//        favouriteRepository.deleteById(id);
//
//    }
//}
//
