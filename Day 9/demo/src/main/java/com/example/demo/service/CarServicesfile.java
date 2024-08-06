package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CarServices;

import com.example.demo.repository.CarServicesRepo;

@Service
public class CarServicesfile {
    @Autowired
    CarServicesRepo carServicesRepo;

    //add new service
    public CarServices addServices(CarServices carServices)
    {
        return carServicesRepo.save(carServices);
    }

    //update service
    public CarServices getBysId(int service_id)
    {
        return carServicesRepo.findById(service_id).orElse(null);
    }
    public Boolean UpdateService(int service_id,CarServices carServices)
    {
        if(this.getBysId(service_id)==null)
        {
            return false;
        }
        try
        {
            carServicesRepo.save(carServices);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    
    //delete service 
    public Boolean deleteService(int service_id) {
        if (getBysId(service_id) == null) {
            return false;
        }
        carServicesRepo.deleteById(service_id);
        return true;
    }
    
}