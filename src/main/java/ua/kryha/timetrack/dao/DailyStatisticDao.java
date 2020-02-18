package ua.kryha.timetrack.dao;

import ua.kryha.timetrack.model.DailyStatistic;

import java.util.List;

public interface DailyStatisticDao extends CrudDao<DailyStatistic> {

    List<DailyStatistic> findAllByUserId(Integer id);

}
