package ua.kryha.timetrack.dao;

import java.util.List;

public interface CrudDao<T> {
     T find(String id);
    void save(T model);
    void update(T model);
    void delete(Integer id);
    List<T> findAll();
}
