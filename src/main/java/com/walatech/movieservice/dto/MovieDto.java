package com.walatech.movieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private int id;
    private String title;
    private String description;
    private float rating;
    private String image;
    private Date createdAt;
    private Date updatedAt;
}
