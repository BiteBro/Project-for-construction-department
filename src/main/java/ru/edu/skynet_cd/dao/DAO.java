package ru.edu.skynet_cd.dao;

import java.util.List;

public interface DAO<T> {
    Long insert(T entity);
    Long delete(long id);
    Long update(T entity);
    T getById(long id);
    List<T> getAll();
}
