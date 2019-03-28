package com.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class IdsDto {
    private int idInt;
    private String idString;
    private List<Integer> idList;
    private ArrayList<CoffeeOrder> orderList;
    private ArrayList<CoffeeShopping> shoppingList;
}
