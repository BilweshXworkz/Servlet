package com.xworkz.shoppingapp.services;

import com.xworkz.shoppingapp.dto.ShoppingDto;

import java.util.List;

public interface ShoppingServices {
    Boolean ValidAndSave(ShoppingDto shoppingDto);
    List<ShoppingDto> getShopping();
    void deleteById(int id);
}
