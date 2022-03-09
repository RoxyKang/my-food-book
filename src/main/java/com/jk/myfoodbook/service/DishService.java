package com.jk.myfoodbook.service;

import com.jk.myfoodbook.mapper.DishMapper;
import com.jk.myfoodbook.model.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    private DishMapper dishMapper;

    @Autowired
    public DishService(DishMapper dishMapper) {
        this.dishMapper = dishMapper;
    }

    public List<Dish> getAllDishes() {
        return dishMapper.getAllDishes();
    }

    public Dish getDishByName(String name) {
        return dishMapper.getDishByName(name);
    }

    public List<Dish> getDishesByType(Integer type) {
        return dishMapper.getDishesByType(type);
    }

    public Dish addDish(Dish dish) {
        dishMapper.addDish(dish);
        return dish;
    }

    public Dish updateDish(Dish dish) {
        dishMapper.updateDish(dish);
        return dish;
    }

    public void deleteDish(Long id) {
        dishMapper.deleteDish(id);
    }
}
