package com.example.demo.scheduller;

import com.example.demo.entity.Rating;
import com.example.demo.reader.HtmlReader;
import com.example.demo.service.HtmlService;
import com.example.demo.service.RatingService;
import com.example.demo.suppress.SuppressThrows;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
@AllArgsConstructor
public class HtmlScheduler {

    private final HtmlReader htmlReader;
    private final HtmlService htmlService;
    private final RatingService ratingService;

    private static final String URL = "http://kinopoisk.ru/top";
    private static final String EVERY_MINUTE = "1 * * * * ?";

    @SuppressThrows
    @Scheduled(cron = EVERY_MINUTE)
    public void updateRatings() {
        System.out.println("Reading...");
        Document document = htmlService.getDocumentByUri(URL);

        List<Rating> ratings = htmlReader.getRatings(document);

        System.out.println("Done.. Saving...");
        ratingService.saveAll(ratings);

        System.out.println("Done.");
    }
}
