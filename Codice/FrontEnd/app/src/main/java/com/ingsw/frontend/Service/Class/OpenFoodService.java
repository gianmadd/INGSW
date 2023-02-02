package com.ingsw.frontend.Service.Class;

import com.ingsw.frontend.Retrofit.OpenFoodApi;
import com.ingsw.frontend.Retrofit.RetrofitService;
import com.ingsw.frontend.Service.Callback;
import com.ingsw.frontend.Service.Interface.IOpenFoodService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class OpenFoodService implements IOpenFoodService {

    private OpenFoodApi openFoodApi;

    public OpenFoodService()  {
        this.openFoodApi = RetrofitService.getRetrofitFood().create(OpenFoodApi.class);
    }

    /*@Override
    public void getProductNameList(Callback callback, String name) {
        openFoodApi.getProductNameList(name)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull List<String> strings) {
                        callback.returnResult(strings);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.returnError(e);
                    }
                });
    }*/

    @Override
    public void getProductName(Callback callback, String name) {
        openFoodApi.getProductName(name,true,true,"product_name")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onSuccess(@NonNull String string) {
                        callback.returnResult(string);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.returnError(e);
                    }
                });
    }
}
