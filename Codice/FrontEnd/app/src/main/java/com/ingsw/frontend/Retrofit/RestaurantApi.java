package com.ingsw.frontend.Retrofit;

import com.ingsw.frontend.Model.Restaurant;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestaurantApi {

    @GET("/restaurant/get/{name}")
    Observable<Restaurant> getByName(@Path("name") String name);
}