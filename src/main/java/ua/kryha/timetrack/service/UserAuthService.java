package ua.kryha.timetrack.service;


import ua.kryha.timetrack.dao.UserDao;
import ua.kryha.timetrack.model.User;
import ua.kryha.timetrack.payload.request.SignInRequest;
import ua.kryha.timetrack.payload.request.SignUpRequest;

import java.util.List;

public class UserAuthService {

    private UserDao userDao;


    public UserAuthService(UserDao userDao) {
        this.userDao = userDao;

    }

    public void signUp(SignUpRequest signUpRequest) {
        userDao.chekByEmail(signUpRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User already exists"));
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                //TODO encoder
                signUpRequest.getPassword()
        );
        userDao.save(user);
    }

    public List<User> find() {
        return userDao.findAll();
    }

    public void signIn(SignInRequest signInRequest) {
        User user = userDao.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Wrong password or email"));
        boolean passEqual = signInRequest.getPassword().equals(user.getPassword());
        if (!passEqual) {
            throw new IllegalArgumentException("Wrong password or email");
        }

    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
