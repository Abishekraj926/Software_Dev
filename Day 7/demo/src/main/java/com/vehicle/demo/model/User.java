package com.vehicle.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    int User_Id;
    String User_Name;
    String vehicle_no;
    public User() {
    }
    public User(int user_Id, String user_Name, String vehicle_no) {
        User_Id = user_Id;
        User_Name = user_Name;
        this.vehicle_no = vehicle_no;
    }
    public int getUser_Id() {
        return User_Id;
    }
    public void setUser_Id(int user_Id) {
        User_Id = user_Id;
    }
    public String getUser_Name() {
        return User_Name;
    }
    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }
    public String getVehicle_no() {
        return vehicle_no;
    }
    public void setVehicle_no(String vehicle_no) {
        this.vehicle_no = vehicle_no;
    }
    
}
