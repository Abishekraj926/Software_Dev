package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarServices;
import com.example.demo.service.CarServicesfile;

@RestController
public class CarServiceController {
    @Autowired
    CarServicesfile carServicesfile;

    @PostMapping("/AddService")
    public ResponseEntity<CarServices> add(@RequestBody CarServices carServices)
    {
        CarServices obj = carServicesfile.addServices(carServices);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @PutMapping("/UpdateService/{service_id}")
    public ResponseEntity<CarServices> put(@PathVariable("service_id") int service_id, @RequestBody CarServices carServices)
    {
        if(carServicesfile.UpdateService(service_id, carServices)==true)
        {
            return new ResponseEntity<>(carServices,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

     @DeleteMapping("/DeleteService/{service_id}")
    public ResponseEntity<Boolean> remove(@PathVariable("service_id") int service_id)
    {
        if(carServicesfile.deleteService(service_id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}