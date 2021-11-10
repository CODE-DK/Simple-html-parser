package com.example.demo.controller;

import com.example.demo.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/rating")
@AllArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping
    public String getRating(Map<String, Object> model) {
        var movies = ratingService.findAll();
        model.put("movies", movies);
        return "rating";
    }
}
