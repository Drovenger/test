package com.codegym.service;

import com.codegym.model.Nation;

public interface NationService extends IService<Nation> {
    Iterable<Nation> findAll();
}
