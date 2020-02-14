package ua.kryha.timetrack.model;

public class PersistenseChoice {

     private Integer id;
     private User user;
     private Activity activity;
     private EUserAction action;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public EUserAction getAction() {
        return action;
    }

    public void setAction(EUserAction action) {
        this.action = action;
    }
}
