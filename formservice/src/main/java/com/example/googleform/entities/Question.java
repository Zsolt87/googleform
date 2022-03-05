package com.example.googleform.entities;

import lombok.Getter;

public class Question {
    private static final short UPPER_RATING = 4;
    private static final short LOWER_RATING = 4;

    @Getter
    short rating;

    public void setRating(short rating){
        if(rating > UPPER_RATING || rating < LOWER_RATING)
            throw new IllegalArgumentException(String.format("Rating limit exceeded (%d,%d)", UPPER_RATING, LOWER_RATING)); //IllegalState?

        this.rating = rating;
    }
}
