package com.example.googleform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<UrlDocument, String> {
    Long findByIsUsedFalseCount();
}
