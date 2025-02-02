package com.xworkz.shoppingapp.repository;

import com.xworkz.shoppingapp.dto.ShoppingDto;
import com.xworkz.shoppingapp.entity.ShoppingEntity;

import java.util.List;

public interface ShoppingRepository {
    Boolean save(ShoppingEntity shoppingEntity);
    List<ShoppingEntity> getShoppingDetails();
    void deleteById(int id);
}
