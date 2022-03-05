package com.example.googleform.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Form {
    Status status;
    List<Question> questions = new ArrayList();
}
