package com.example.forum.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.forum.model.Feedback;
import com.example.forum.repository.FeedbackRepository;

@Service
public class FeedbackService {
    @Autowired
    FeedbackRepository pr;
    
    public Feedback create(Feedback p) {
        return pr.save(p);
    }
    
    public List<Feedback> getAllPosts() {
        return pr.findAll();
    }
    
    public Feedback getPostById(int id) {
        return pr.findById(id).orElse(null);
    }
    
    public boolean updatePost(int id, Feedback p) {
        if(this.getPostById(id) == null) {
            return false;
        }
        p.setId(id);
        pr.save(p);
        return true;
    }
    
    public boolean deletePost(int id) {
        if(this.getPostById(id) == null) {
            return false;
        }
        pr.deleteById(id);
        return true;
    }
}
