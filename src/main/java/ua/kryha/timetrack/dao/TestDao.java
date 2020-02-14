package ua.kryha.timetrack.dao;

import ua.kryha.timetrack.model.User;

import java.util.List;

public interface TestDao extends CrudDao<User> {

    List<User> findAll();
}
