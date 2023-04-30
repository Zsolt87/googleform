package com.example.googleform.data;

import com.example.googleform.model.FormStatus;
import com.example.googleform.model.question.*;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@Data
//@Builder
//public class FormDTO {
//    private UUID id;
//    @Size(min=4)
//    private String name;
//    @NotNull
//    private UUID eventId;
//
//    @Builder.Default
//    private List<Question> questionsCheckBox = new ArrayList();
//    @Builder.Default
//    private List<Question> questionsRadioButton = new ArrayList();
//    @Builder.Default
//    private List<FreeTextQuestion> questionsFreeText = new ArrayList();
//}

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class FormDTO {
    UUID id;
    @Size(min=4)
    String name;
    @NotNull
    UUID eventId;
    FormStatus status;

    @Builder.Default
    List<CheckBoxQuestion> questionsCheckBox = new ArrayList();
    @Builder.Default
    List<RadioButtonQuestion> questionsRadioButton = new ArrayList();
    @Builder.Default
    List<FreeTextQuestion> questionsFreeText = new ArrayList();
}
