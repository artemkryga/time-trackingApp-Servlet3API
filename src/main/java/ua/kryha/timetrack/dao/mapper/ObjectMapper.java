package ua.kryha.timetrack.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ObjectMapper<T> {

    T extractFromResultSet(ResultSet resultSet) throws SQLException;

    List<T> extractListFromResultSet(ResultSet resultSet) throws SQLException;

}
