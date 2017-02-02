package com.postit.api;

import com.postit.entity.Postit;
import com.postit.service.PostitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by SQLI on 02/02/17.
 */
@RestController
@RequestMapping("/api/postit")
public class PostitController {

    private final PostitService postitService;

    @Autowired
    public PostitController(PostitService postitService){
        this.postitService = postitService;
    }

    @GetMapping
    public List<Postit> findAll(){
        return postitService.findAll();
    }
}
