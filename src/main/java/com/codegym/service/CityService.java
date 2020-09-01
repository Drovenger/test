package com.codegym.service;

import com.codegym.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService extends IService<City> {
    Page<City> findAll(Pageable pageable);

    Page<City> findAllByNameContaining(String city, Pageable pageable);
}
