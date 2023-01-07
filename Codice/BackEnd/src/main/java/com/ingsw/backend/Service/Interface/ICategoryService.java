package com.ingsw.backend.Service.Interface;

import com.ingsw.backend.Model.Category;
import java.util.List;

public interface ICategoryService {

    public Category create(Category category);

    public Boolean deleteById(Integer id);

    public List<Category> getByMenuQrCode(String menu);
}