package com.ingsw.backend.Model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "menu")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Long.class)
public class Menu implements Serializable {

    //PRIMARY KEY
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMenu")
    private Integer id;

    //REFERENCES
    @OneToMany(mappedBy = "menu", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Category> categoryList = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "restaurant_name", referencedColumnName = "name")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonManagedReference
    private Restaurant restaurant;

    // ATTRIBUTES

    //CONSTRUCTORS
    public Menu() {
    }

    public Menu(Integer id, Restaurant restaurant, String qrCode) {
        this.id = id;
        this.restaurant = restaurant;
    }

    // -------------------------------------------------


    //GETTERS AND SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
