package ru.edu.skynet_cd.dao;

import java.util.List;

public interface UserDAO<T> {
    Long insert(T entity);
    Long delete(long id);
    Long update(T entity);
    T getById(long id);
    List<T> getByPosition(long positionId);
    List<T> getAll();
}
