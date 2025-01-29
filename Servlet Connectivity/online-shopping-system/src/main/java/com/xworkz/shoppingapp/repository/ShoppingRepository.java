package com.xworkz.shoppingapp.repository;

import com.xworkz.shoppingapp.dto.ShoppingDto;
import com.xworkz.shoppingapp.entity.ShoppingEntity;

public interface ShoppingRepository {
    Boolean save(ShoppingEntity shoppingEntity);
}
