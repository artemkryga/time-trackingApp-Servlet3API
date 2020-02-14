package ua.kryha.timetrack.service;

import ua.kryha.timetrack.dao.TestDao;
import ua.kryha.timetrack.model.User;

import java.util.List;

public class TestService {

    private TestDao testDao;

    public TestService(TestDao testDao) {
        this.testDao = testDao;
    }

    public List<User> find(){
       return testDao.findAll();
    }
}
