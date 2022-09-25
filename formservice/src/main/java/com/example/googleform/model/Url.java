package com.example.googleform.entities;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor(staticName = "of")
@Value
public class Url {
    String url;
}
