package ua.kryha.timetrack.dao;

import ua.kryha.timetrack.model.Activity;

public interface ActivityDao extends CrudDao<Activity> {
    Activity getActivityByName(String name);
}
