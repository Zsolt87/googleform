package com.example.googleform;

import com.example.googleform.entities.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestQuestion {
    @Test
    public void testRatingLimitation(){
        Question q = new Question();
        assertThrows(IllegalArgumentException.class, () -> q.setRating((short)5));
    }
}
