package com.ingsw.frontend.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurant implements Serializable {

    //PRIMARY KEY
    @Expose
    @SerializedName("name")
    private String name;

    //ATTRIBUTES
    @Expose
    @SerializedName("description")
    private String description;

    @Expose
    @SerializedName("locality")
    private String locality;

    @Expose
    @SerializedName("tables")
    private Integer tables;

    @Expose
    @SerializedName("seats")
    private Integer seats;

    @Expose
    @SerializedName("touristic")
    private boolean touristic;

    //REFERENCES
    @Expose
    @SerializedName("menu_id")
    private Integer menuId;

    //CONSTRUCTORS
    public Restaurant() {
    }

    public Restaurant(String name, String description, String locality, Integer tables, Integer seats, boolean touristic) {
        this.name = name;
        this.description = description;
        this.locality = locality;
        this.tables = tables;
        this.seats = seats;
        this.touristic = touristic;
    }

    //GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Integer getTables() {
        return tables;
    }

    public void setTables(Integer tables) {
        this.tables = tables;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public boolean isTouristic() {
        return touristic;
    }

    public void setTouristic(boolean touristic) {
        this.touristic = touristic;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}
