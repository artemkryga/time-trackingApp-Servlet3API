package ua.kryha.timetrack.dao.implDao;

import org.apache.log4j.Logger;
import ua.kryha.timetrack.dao.CategoryDao;
import ua.kryha.timetrack.dao.mapper.ActivityMapper;
import ua.kryha.timetrack.dao.mapper.CategoryMapper;
import ua.kryha.timetrack.model.Activity;
import ua.kryha.timetrack.model.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static ua.kryha.timetrack.dao.Queries.*;

import static ua.kryha.timetrack.dao.Queries.SQL_SELECT_ACTIVITY_BY_NAME;

public class CategoryDaoJdbcImpl implements CategoryDao {
    final static Logger logger = Logger.getLogger(UserDaoJdbcImpl.class);

    private DataSource dataSource;

    public CategoryDaoJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Category> findAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_CATEGORIES)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            CategoryMapper categoryMapper = new CategoryMapper();

            return categoryMapper.extractListFromResultSet(resultSet);


        } catch (SQLException e) {
            logger.warn("can't find all categories");
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Category find(String id) {
        throw new IllegalStateException();
    }

    @Override
    public void save(Category model) {
        throw new IllegalStateException();
    }

    @Override
    public void update(Category model) {
        throw new IllegalStateException();
    }

    @Override
    public void delete(Integer id) {
        throw new IllegalStateException();
    }


}
