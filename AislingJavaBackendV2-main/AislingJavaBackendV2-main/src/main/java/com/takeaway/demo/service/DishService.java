package com.takeaway.demo.service;

import com.takeaway.demo.dao.DishRepository;
import com.takeaway.demo.entity.Dish;
import com.takeaway.demo.entity.DishCategory;
import com.takeaway.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {

    @Autowired
    private DishRepository dishRepository;

    //save a dish
    public Dish saveDish(Dish dish){
        return dishRepository.save(dish);
    }

    //get dish by id
    public Dish getDishById(Long id){
        return this.dishRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Dish not found: " + id));
    }

    //delete dish
    public String deleteDish(Long id){
        dishRepository.deleteById(id);
        return "Dish " + id +" deleted.";
    }

    //update dish
    //price
    //and/or description if needed
    public Dish updateDish(Dish dish){
        Dish existingDish = dishRepository.findById(dish.getId()).orElse(null);
        existingDish.setUnitPrice(dish.getUnitPrice());
        return dishRepository.save(existingDish);
    }

}//end class
