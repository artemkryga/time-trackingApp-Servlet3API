package ua.kryha.timetrack.dao;

public interface Queries {

    String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    String SQL_FIND_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    String SQL_INSERT_USER = "INSERT INTO users(username, email, password)" + "values (?, ?, ?);";
    String SQL_SELECT_ALL =  "SELECT * FROM users";
    String SQL_SELECT_ALL_ACTIVITIES = "select activity.name, category.name from activity left join category on activity.fk_category = category.id";
    String SQL_SELECT_ACTIVITY_BY_NAME = "SELECT * FROM activity WHERE name = ?";
    String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM category";

}
