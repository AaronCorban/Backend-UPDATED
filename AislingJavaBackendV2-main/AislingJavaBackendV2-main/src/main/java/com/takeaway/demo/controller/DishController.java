package com.takeaway.demo.controller;

import com.takeaway.demo.entity.Dish;
import com.takeaway.demo.entity.DishCategory;
import com.takeaway.demo.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//api's
//talks to ReviewService class
@RestController
public class DishController {

    @Autowired
    private DishService dishService;

    //add a dish
    @PostMapping("/dishes")
    public Dish addDish(@RequestBody Dish dish){
        return dishService.saveDish(dish);
    }

    //get dish by id
    @GetMapping("/dishes/{id}")
    public Dish findDishById(@PathVariable Long id){
        return dishService.getDishById(id);
    }

    //delete a dish
    @DeleteMapping("/dishes/{id}")
    public String deleteReview(@PathVariable Long id){
        return dishService.deleteDish(id);
    }

    //update a dish
    @PutMapping("/dishes/{id}")
    public Dish updateDish(@RequestBody Dish dish){
        return dishService.updateDish(dish);
    }

}//end class
