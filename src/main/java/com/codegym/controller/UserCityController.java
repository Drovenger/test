package com.codegym.controller;

import com.codegym.model.City;
import com.codegym.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/user/cities")
public class UserCityController {

    @Autowired
    private CityService cityService;

    @GetMapping("")
    public ModelAndView listCities(@RequestParam("search") Optional<String> keyword, @PageableDefault(size = 10) Pageable pageable){
        Page<City> cities;
        if (keyword.isPresent()){
            cities=cityService.findAllByNameContaining(keyword.get(),pageable);
        } else {
            cities=cityService.findAll(pageable);
        }
        ModelAndView modelAndView=new ModelAndView("/city/listForUser");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable("id") Long id){
        City city=cityService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/city/viewForUser");
        modelAndView.addObject("city",city);
        return modelAndView;
    }
}
