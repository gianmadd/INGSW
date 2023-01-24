package com.ingsw.backend.Service.Interface;

import com.ingsw.backend.Model.TableRestaurant;

import java.util.List;
import java.util.Optional;

public interface ITableRestaurantService {

    List<TableRestaurant> getByRestaurantName(String name);

    TableRestaurant findByRestaurantNameAndId(String name, Integer id);

    Long countByRestaurantName(String restaurant_name);

}
