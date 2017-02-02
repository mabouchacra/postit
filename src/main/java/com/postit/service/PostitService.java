package com.postit.service;

import com.postit.entity.Postit;

import java.util.List;

/**
 * Created by SQLI on 02/02/17.
 */
public interface PostitService {

    List<Postit> findAll();
}
