package com.ingsw.backend.Service.Interface;

import com.ingsw.backend.Model.Restaurant;
import com.ingsw.backend.Model.TableRestaurant;

import java.util.List;

public interface ITableRestaurantService {

    List<TableRestaurant> getByRestaurantName(String name);
}
