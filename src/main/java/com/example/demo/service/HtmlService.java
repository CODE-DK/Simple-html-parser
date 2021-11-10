package com.example.demo.service;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import org.jsoup.nodes.Document;

@Service
public class HtmlService {

    @SneakyThrows
    public Document getDocumentByUri(String url) {
        return Jsoup.connect(url).get();
    }
}
