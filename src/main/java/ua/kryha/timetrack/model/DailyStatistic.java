package ua.kryha.timetrack.model;

import java.sql.Date;

public class DailyStatistic {

    private Integer id;

    private Date date;

    private String time;

    private Integer usr;

    private Activity activity;

    public DailyStatistic() {
    }

    public DailyStatistic(Integer id, Date date, String time, Integer usr, Activity activity) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.usr = usr;
        this.activity = activity;
    }

    public DailyStatistic(Date date, String time, Integer usr, Activity activity) {
        this.date = date;
        this.time = time;
        this.usr = usr;
        this.activity = activity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getUsr() {
        return usr;
    }

    public void setUsr(Integer usr) {
        this.usr = usr;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
