package com.example.forum.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.forum.model.Register;
import com.example.forum.repository.RegisterRepository;

@Service
public class RegisterService {
    @Autowired
    RegisterRepository cr;
    
    public Register create(Register c) {
        return cr.save(c);
    }
    
    public List<Register> getAllCategories() {
        return cr.findAll();
    }
    
    public Register getCategoryById(int id) {
        return cr.findById(id).orElse(null);
    }
    
    public boolean updateCategory(int id, Register c) {
        if(this.getCategoryById(id) == null) {
            return false;
        }
        try {
            cr.save(c);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean deleteCategory(int id) {
        if(this.getCategoryById(id) == null) {
            return false;
        }
        cr.deleteById(id);
        return true;
    }
}
