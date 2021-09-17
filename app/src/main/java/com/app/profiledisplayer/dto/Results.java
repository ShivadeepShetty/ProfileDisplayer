package com.app.profiledisplayer.dto;

import java.util.jar.Attributes;

public class Results
{
    private String gender;

    private PeopleResponse name;

   // private Location location;

    private String email;

   private Picture picture;

    private String nat;

    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return this.gender;
    }
    public void setName(PeopleResponse name){
        this.name = name;
    }
    public PeopleResponse getName(){
        return this.name;
    }
  /*  public void setLocation(Location location){
        this.location = location;
    }*/
   /* public Location getLocation(){
        return this.location;
    }*/
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPicture(Picture picture){
        this.picture = picture;
    }
    public Picture getPicture(){
        return this.picture;
    }
    public void setNat(String nat){
        this.nat = nat;
    }
    public String getNat(){
        return this.nat;
    }
}
