package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 0L;
    @Column(updatable = true)
    private LocalDate date = LocalDate.now();
    @Column(name = "original_name", updatable = false)
    private String originalName;
    @Column(updatable = true)
    private Double rating;
    @Column(name = "voting_number", updatable = true)
    private Long votingNumber;
    @Column(name = "year", updatable = false)
    private Integer year;

    public Rating(Double rating, String originalName, Integer year, Long votingNumber) {
        this.rating = rating;
        this.originalName = originalName;
        this.year = year;
        this.votingNumber = votingNumber;
    }
}
