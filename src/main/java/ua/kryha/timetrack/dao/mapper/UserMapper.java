package ua.kryha.timetrack.dao.mapper;

import ua.kryha.timetrack.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserMapper implements ObjectMapper<User> {

    @Override
    public User extractFromResultSet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            String emaly = resultSet.getString("email");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            return new User(username, emaly, password);
        }
        return new User();
    }

    @Override
    public List<User> extractListFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}
