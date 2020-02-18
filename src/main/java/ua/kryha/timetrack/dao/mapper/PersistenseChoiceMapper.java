package ua.kryha.timetrack.dao.mapper;

import ua.kryha.timetrack.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersistenseChoiceMapper implements ObjectMapper<PersistenseChoice> {

    @Override
    public PersistenseChoice extractFromResultSet(ResultSet resultSet) throws SQLException {
        throw new IllegalArgumentException();
    }

    @Override
    public List<PersistenseChoice> extractListFromResultSet(ResultSet resultSet) throws SQLException {

        List<PersistenseChoice> list = new ArrayList<>();

        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            EUserAction action = Enum.valueOf(EUserAction.class, resultSet.getString("action"));
            String nameActivity = resultSet.getString("name");
            String username = resultSet.getString("username");

            list.add(new PersistenseChoice(id, action, new Activity(nameActivity), new User(username)));
        }

        return list;
    }
}
