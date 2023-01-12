package com.ingsw.frontend.Service.Class;

import com.ingsw.frontend.Service.Callback;
import com.ingsw.frontend.Service.Interface.IAllergenService;
import com.ingsw.frontend.Model.Allergen;
import com.ingsw.frontend.Retrofit.AllergenApi;
import com.ingsw.frontend.Retrofit.RetrofitService;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AllergenService implements IAllergenService {

    private AllergenApi allergenApi;

    public AllergenService() {
        this.allergenApi = RetrofitService.getRetrofit().create(AllergenApi.class);
    }

    @Override
    public void create(Callback callback, Allergen allergen){
        allergenApi.create(allergen)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Allergen>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull Allergen allergen) {
                        callback.returnResult(allergen);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.returnError(e);
                    }

                    @Override
                    public void onComplete() {}
                });
    }

    @Override
    public void getAll(Callback callback){
        allergenApi.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Allergen>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {}

                    @Override
                    public void onNext(@NonNull List<Allergen> allergens) {
                        callback.returnResult(allergens);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.returnError(e);
                    }

                    @Override
                    public void onComplete() {}
                });
    }

}