package ua.kryha.timetrack.dao;

import ua.kryha.timetrack.model.User;

import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    Optional<User> findByEmail(String email);
    //TODO check boolean
    Optional<User> chekByEmail(String email);

}
