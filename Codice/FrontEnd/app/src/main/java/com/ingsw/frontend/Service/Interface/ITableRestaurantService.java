package com.ingsw.frontend.Service.Interface;

import com.ingsw.frontend.Service.Callback;

public interface ITableRestaurantService {

    void getByRestaurantName(Callback callback, String name);
}
