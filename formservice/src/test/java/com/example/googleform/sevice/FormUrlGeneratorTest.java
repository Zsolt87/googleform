package com.example.googleform.sevice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormUrlGeneratorTest {

    FormUrlGenerator formUrlGenerator = new FormUrlGenerator(null, null, 0);

    @Test
    public void testGetNext(){
        assertAll(
                () -> assertEquals("AAAAB",formUrlGenerator.getNext("AAAAA")),
                () -> assertEquals("AAABA",formUrlGenerator.getNext("AAAAZ")),
                () -> assertEquals("AZBAA",formUrlGenerator.getNext("AZAZZ")),
                () -> assertEquals("AZAZB",formUrlGenerator.getNext("AZAZA")));
    }
}