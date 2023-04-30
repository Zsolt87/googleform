package com.example.googleform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends MongoRepository<UrlDocument, String> {
    Optional<UrlDocument> findFirstByOrderByUrlDesc();
}
