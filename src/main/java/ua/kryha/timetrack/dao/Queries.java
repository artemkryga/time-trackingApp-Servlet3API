package ua.kryha.timetrack.dao;

public interface Queries {

    String SQL_SELECT_BY_ID = "SELECT * FROM users WHERE id = ?";
    String SQL_FIND_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    String SQL_INSERT_USER = "INSERT INTO users(username, email, password)" + "values (?, ?, ?);";
    String SQL_SELECT_ALL = "SELECT * FROM users";
    String SQL_SELECT_ALL_ACTIVITIES = "select activity.name, category.name , activity.id from activity left join category on activity.fk_category = category.id";
    String SQL_SELECT_ACTIVITY_BY_NAME = "SELECT * FROM activity WHERE name = ?";
    String SQL_SELECT_ALL_ACTIVITIES_ID_BY_USER = "select activity_id from user_activities where user_id =(select id from users where username = ?)";
    String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM category";
    String SQL_FIND_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    String SQL_INSERT_DAILY_STATISTIC = "INSERT INTO daily_statistics(date, time, user_id , fk_activity_daily_statistics)"
            + "values (?, ?, ?, ?);";
    String SQL_DELETE_PERSISTENSE_CHOICE_BY_ID = "DELETE FROM persistence_choice" +
            " WHERE id = ?";
    String SQL_INSERT_PERSISTENCE_CHOICE = "INSERT INTO persistence_choice(action, fk_activity, fk_user) " +
            "values (?, ?, ?)";
    String SQL_SELECT_ALL_PERSISTENCE_CHOICES = "SELECT persistence_choice.id , persistence_choice.action, activity.name , username\n" +
            "FROM persistence_choice\n" +
            "    left join activity on persistence_choice.fk_activity = activity.id\n" +
            "    left join users on persistence_choice.fk_user = users.id ";
    String SQL_SELECT_ACTIVITIES_BY_USER_ID = "select\n" +
            "       a.name ,  c.name from user_activities\n" +
            "    left join activity a on user_activities.activity_id = a.id\n" +
            "     left join category c on a.fk_category = c.id where user_activities.user_id = ?";
    String SQL_SELECT_DAILY_STATISTICS_BY_USER_ID = "select daily_statistics.id, date , time , user_id , a.name , c.name from daily_statistics\n" +
            "left join activity a on daily_statistics.fk_activity_daily_statistics = a.id\n" +
            "left join category c on a.fk_category = c.id where user_id = ?";

    String SQL_INSERT_COLUMN_INTO_USER_ACTIVITIES = "INSERT INTO user_activities(user_id , activity_id) values (? , ?)";
    String SQL_DELETE_COLUMN_FROM_USER_ACTIVITIES = "DELETE FROM user_activities where user_id = ? and activity_id = ? ";

}
