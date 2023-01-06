package com.ingsw.backend.Model;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
public class Menu {

    //PRIMARY KEY
    @Id
    @Column(name = "qrCode")
    private String qrCode;

    //REFERENCES
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Element> elementList = new ArrayList<>();

    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Category> categoryList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "name")
    private Restaurant restaurant;

    // -------------------------------------------------

    //CONSTRUCTORS
    public Menu() {
    }

    public Menu(String qrCode, Restaurant restaurant) {
        this.qrCode = qrCode;
        this.restaurant = restaurant;
    }


    // -------------------------------------------------


    //GETTERS AND SETTERS

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // -------------------------------------------------


}
