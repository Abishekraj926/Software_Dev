package com.example.demo.model;

import org.springframework.stereotype.Service;

import jakarta.persistence.Id;

@Service
public class CarServices {
    @Id
    private int service_id;
    private String title;
    private String description;
    private String cost;
    private String icon;
    public CarServices(int service_id, String title, String description, String cost, String icon) {
        this.service_id = service_id;
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.icon = icon;
    }
    public CarServices() {
    }
    public int getService_id() {
        return service_id;
    }
    public void setService_id(int service_id) {
        this.service_id = service_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
}