package com.app.profiledisplayer.dto;

public class Location
{
    private Street street;

    private String city;

    private String state;

    private String country;

    private int postcode;

    private Coordinates coordinates;

    private Timezone timezone;

    public void setStreet(Street street){
        this.street = street;
    }
    public Street getStreet(){
        return this.street;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return this.city;
    }
    public void setState(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setPostcode(int postcode){
        this.postcode = postcode;
    }
    public int getPostcode(){
        return this.postcode;
    }
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }
    public Coordinates getCoordinates(){
        return this.coordinates;
    }
    public void setTimezone(Timezone timezone){
        this.timezone = timezone;
    }
    public Timezone getTimezone(){
        return this.timezone;
    }
}
