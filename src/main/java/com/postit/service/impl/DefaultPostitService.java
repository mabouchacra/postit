package com.postit.service.impl;

import com.postit.entity.Postit;
import com.postit.repository.PostitRepository;
import com.postit.service.PostitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SQLI on 02/02/17.
 */
@Service
public class DefaultPostitService implements PostitService {

    private final PostitRepository postitRepository;

    @Autowired
    public DefaultPostitService(PostitRepository postitRepository){
        this.postitRepository = postitRepository;
    }

    @Override
    public List<Postit> findAll() {
        return postitRepository.findAll();
    }
}
