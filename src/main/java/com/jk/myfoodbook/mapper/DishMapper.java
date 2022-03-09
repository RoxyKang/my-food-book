package com.jk.myfoodbook.mapper;

import com.jk.myfoodbook.model.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMapper {
    List<Dish> getAllDishes();

    void addDish(Dish dish);

    Dish getDishByName(String name);

    List<Dish> getDishesByType(Integer type);

    void updateDish(Dish dish);

    void deleteDish(Long id);
}
