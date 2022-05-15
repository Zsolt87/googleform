package com.example.googleform.converter;

public interface Converter<DTO, MODEL, DOCUMENT> {
    public DTO convertToDto(MODEL model);
    public MODEL convertToModelFromDto(DTO dto);
    public DOCUMENT convertToDocument(MODEL model);
    public MODEL convertToModelFromDocument(DOCUMENT document);
}
