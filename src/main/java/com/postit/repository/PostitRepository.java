package com.postit.repository;

import com.postit.entity.Postit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by SQLI on 02/02/17.
 */
public interface PostitRepository extends MongoRepository<Postit, String> {
}
