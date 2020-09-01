package com.codegym.service;

public interface IService<T> {
    T findById(Long id);

    void save(T model);

    void delete(Long id);
}
