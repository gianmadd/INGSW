package com.ingsw.frontend.Service.Interface;

import com.ingsw.frontend.Service.Callback;

public interface ITableRestaurantService {

    void getByRestaurantName(Callback callback, String name);

    void countTotalTableByRestaurantName(Callback callback, String name);

    void getById(Callback callback, Integer id);
}
