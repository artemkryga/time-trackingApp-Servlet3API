package ua.kryha.timetrack.dao.mapper;

import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.Category;
import ua.kryha.timetrack.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryMapper implements ObjectMapper<Category>{

    @Override
    public List<Category> extractListFromResultSet(ResultSet resultSet) throws SQLException {
        List<Category> list = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            list.add(new Category(name));
        }
        return list;
    }

    @Override
    public Category extractFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }
}
