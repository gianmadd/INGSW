package com.ingsw.frontend.Service.Interface;

import com.ingsw.frontend.Model.Category;
import com.ingsw.frontend.Model.Enumerations.Aliment_Type;
import com.ingsw.frontend.Service.Callback;

public interface ICategoryService {

    void create(Callback callback, Category category);

    void getByMenuId(Callback callback, Integer id);

    void getByMenuIdAndAliment(Callback callback, Integer id, Aliment_Type aliment_type);

    void deleteById(Callback callback, Integer Id);
}
