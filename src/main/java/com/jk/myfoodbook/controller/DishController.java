package com.jk.myfoodbook.controller;

import com.jk.myfoodbook.model.Dish;
import com.jk.myfoodbook.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dish")
public class DishController {
    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    // localhost:8080/api/dish
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @GetMapping(path = "/name")
    // localhost:8080/api/dish/name?name=potato
    public Dish getDishByName(@RequestParam String name) {
        return dishService.getDishByName(name);
    }

    @GetMapping(path = "/type")
    // localhost:8080/api/dish/type?type=0
    public List<Dish> getDishesByType(@RequestParam Integer type) {
        return dishService.getDishesByType(type);
    }

    @PostMapping(path = "/add")
    // localhost:8080/api/dish/add
    public ResponseEntity<String> addDish(@RequestBody Dish dish) {
        try {
            Dish addedDish = dishService.addDish(dish);
            return ResponseEntity.ok("Added dish: " + addedDish.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(path = "/update")
    // localhost:8080/api/dish/update
    public ResponseEntity<String> updateDish(@RequestBody Dish dish) {
        try {
            Dish updateDish = dishService.updateDish(dish);
            return ResponseEntity.ok("Updated dish: " + updateDish.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete/{did}")
    // localhost:8080/api/dish/delete/1
    public ResponseEntity<String> deleteDish(@PathVariable("did") Long id) {
        try {
            dishService.deleteDish(id);
            return ResponseEntity.ok("Deleted dish: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
