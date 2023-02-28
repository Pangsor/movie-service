package com.walatech.movieservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private long createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private long updatedAt;
}
