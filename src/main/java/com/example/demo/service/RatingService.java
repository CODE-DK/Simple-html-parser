package com.example.demo.service;

import com.example.demo.entity.Rating;
import com.example.demo.repo.RatingRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingService {

    private final RatingRepo ratingRepo;

    @Transactional
    public void saveAll(List<Rating> ratings) {
        ratingRepo.saveAll(ratings);
    }

    @Transactional
    public List<Rating> findAll() {
        return ratingRepo.findAll();
    }
}
