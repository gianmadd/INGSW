package com.ingsw.frontend.Service.Class;

import com.ingsw.frontend.Service.Callback;
import com.ingsw.frontend.Service.Interface.IOrderService;
import com.ingsw.frontend.Model.Order;
import com.ingsw.frontend.Retrofit.OrderApi;
import com.ingsw.frontend.Retrofit.RetrofitService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OrderService implements IOrderService {

    private OrderApi orderApi;

    public OrderService() {
        this.orderApi = RetrofitService.getRetrofit().create(OrderApi.class);
    }

    @Override
    public void create(Callback callback, Order order){
        orderApi.create(order)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<Void>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        callback.returnResult(true);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(false);
                    }
                });
    }

    @Override
    public void deleteById(Callback callback, Integer id){
        orderApi.deleteById(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<Void>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull Void unused) {
                        callback.returnResult(true);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(e);
                        callback.returnResult(false);
                    }
                });
    }

    @Override
    public void getByTableRestaurantId(Callback callback, Integer id){
        orderApi.getByTableRestaurantId(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<Order>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull List<Order> orderList) {
                        callback.returnResult(orderList);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.returnError(e);
                    }
                });
    }
}
