package com.example.forum.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.forum.model.Feedback;
import com.example.forum.service.FeedbackService;

@RestController
@RequestMapping("/post")
public class FeedbackController {
    @Autowired
    FeedbackService ps;
    
    @PostMapping("/post")
    public ResponseEntity<Feedback> add(@RequestBody Feedback p) {
        Feedback newPost = ps.create(p);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
    
    @GetMapping("/getdetails")
    public ResponseEntity<List<Feedback>> getAllPosts() {
        List<Feedback> obj = ps.getAllPosts();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/update/{postId}")
    public ResponseEntity<Feedback> update(@PathVariable("postId") int id, @RequestBody Feedback p) {
        if(ps.updatePost(id, p)) {
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Boolean> delete(@PathVariable("postId") int id) {
        if(ps.deletePost(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
