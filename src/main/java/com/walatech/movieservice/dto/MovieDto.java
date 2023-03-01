package com.walatech.movieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private int id;

    @NotEmpty(message = "Title should not be null or empty")
    private String title;

    @NotEmpty(message = "Description should not be null or empty")
    private String description;

    private float rating;

    private String image;
    private Date createdAt;
    private Date updatedAt;
}
