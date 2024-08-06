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
import com.example.forum.model.Register;
import com.example.forum.service.RegisterService;

@RestController
@RequestMapping("/category")
public class RegisterController {
    @Autowired
    RegisterService cs;
    
    @PostMapping("/post")
    public ResponseEntity<Register> add(@RequestBody Register c) {
        Register newCategory = cs.create(c);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }
    
    @GetMapping("/getdetails")
    public ResponseEntity<List<Register>> getAllCategories() {
        List<Register> obj = cs.getAllCategories();
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/update/{categoryId}")
    public ResponseEntity<Register> update(@PathVariable("categoryId") int id, @RequestBody Register c) {
        if(cs.updateCategory(id, c)) {
            return new ResponseEntity<>(c, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<Boolean> delete(@PathVariable("categoryId") int id) {
        if(cs.deleteCategory(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
