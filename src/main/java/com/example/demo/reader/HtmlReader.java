package com.example.demo.reader;

import com.example.demo.entity.Rating;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HtmlReader {

    public static final String NUMERIC = "[0-9 ]+";
    public static final String DELIMITER = ", ";
    public static final String NOT_DIGITS = "\\D";
    public static final String EMPTY = "";

    public static final String ITEM_UPPER_WRAPPER = "desktop-rating-selection-film-item__upper-wrapper";
    public static final String SELECTION_FILM_ITEM_META = "selection-film-item-meta";
    public static final String SELECTION_FILM_ITEM_META_NAME = "selection-film-item-meta__name";
    public static final String ITEM_META_ORIGINAL_NAME = "selection-film-item-meta__original-name";
    public static final String ITEM_USER_DATA_RATING = "rating film-item-user-data__rating";
    public static final String RATING__VALUE_POSITIVE = "rating__value rating__value_positive";
    public static final String RATING_COUNT = "rating__count";


    public List<Rating> getRatings(Document document) {
        Elements movies = document.getElementsByClass(ITEM_UPPER_WRAPPER);

        List<Rating> ratingList = new ArrayList<>();

        movies.forEach(movie -> {
            Element root = movie.getElementsByClass(SELECTION_FILM_ITEM_META).first();
            Element name = root.getElementsByClass(SELECTION_FILM_ITEM_META_NAME).first();
            Element origin = root.getElementsByClass(ITEM_META_ORIGINAL_NAME).first();

            String originName;
            if (origin.text().matches(NUMERIC)) {
                originName = name.text() + DELIMITER + origin.text();
            } else {
                originName = origin.text();
            }

            String year = originName.replaceAll(NOT_DIGITS, EMPTY);

            Element ratingElement = movie.getElementsByClass(ITEM_USER_DATA_RATING).first();

            String rating = ratingElement.getElementsByClass(RATING__VALUE_POSITIVE).first().text();
            String votingNumber = ratingElement.getElementsByClass(RATING_COUNT).first().text();

            Rating currentRating = new Rating(
                    Double.valueOf(rating),
                    originName,
                    Integer.valueOf(year),
                    Long.valueOf(votingNumber.replaceAll(NOT_DIGITS, EMPTY))
            );
            ratingList.add(currentRating);
        });

        return ratingList;
    }
}
