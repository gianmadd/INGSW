package com.ingsw.backend.Service.Interface;

import com.ingsw.backend.Model.Restaurant;

import java.util.Optional;

public interface IRestaurantService {

    public Optional<Restaurant> getByName(String name);
}