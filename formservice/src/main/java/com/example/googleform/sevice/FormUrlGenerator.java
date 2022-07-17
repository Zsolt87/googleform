package com.example.googleform.sevice;

import com.example.googleform.converter.UrlConverter;
import com.example.googleform.entities.Url;
import com.example.googleform.repository.UrlDocument;
import com.example.googleform.repository.UrlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FormUrlGenerator {
    public static final String FIRST_URL = "AAAAA";
    public static final String LAST_AVAILABLE_URL = "AZZZZ";
    public static final char LAST_AVAILABLE_CHARACTER = 'Z';
    public static final char FIRST_AVAILABLE_CHARACTER = 'A';
    private final UrlRepository urlRepository;
    private final UrlConverter urlConverter;
    private final int batchSize;

    public FormUrlGenerator(UrlRepository urlRepository, UrlConverter urlConverter,
                            @Value("${googleform.url-generation.batch-size}") int batchSize) {
        this.urlRepository = urlRepository;
        this.urlConverter = urlConverter;
        this.batchSize = batchSize;
    }

    @Transactional
    @Scheduled(fixedRateString = "${googleform.url-generation.fixed-rate-ms}")
    public void generateFormUrl(){
        List<Url> urls = generateUrl(batchSize);
        List<UrlDocument> documents = urls.stream().map(urlConverter::convertToDocument).collect(Collectors.toList());
        urlRepository.saveAll(documents);
    }

    public List<Url> generateUrl(int generatedItems){
        List<Url> urls = new ArrayList<>();

        String previousUrl = getFirstUsedUrl();
        for(int i = 0; i < generatedItems; i++){
            previousUrl = getNext(previousUrl);
            urls.add(Url.of(previousUrl));
        }

        return urls;
    }

    private String getFirstUsedUrl(){
        return urlRepository.findFirstByOrderByUrlDesc().orElse(UrlDocument.builder().url(FIRST_URL).build()).getUrl();
    }

    String getNext(String url){
        if(url == null || LAST_AVAILABLE_URL.equals(url)) {
            throw new IllegalArgumentException("Cannot find next URL from " + url);
        }

        int index = url.length()-1;

        while(url.charAt(index) == LAST_AVAILABLE_CHARACTER){
            index--;
        }

        return getNextUrl(url, index);
    }

    private String getNextUrl(String url, int index) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < url.length(); i++){
            if(i < index){
                builder.append(url.charAt(i));
            }else if(i == index){
                builder.append((char)(url.charAt(i)+1));
            }else{
                builder.append(FIRST_AVAILABLE_CHARACTER);
            }
        }
        return builder.toString();
    }
}
