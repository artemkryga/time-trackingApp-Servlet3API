package ua.kryha.timetrack.payload.request;

public class ActivityRequest {
    private String nameAct;

    private String userName;

    private String action;

    public ActivityRequest() {
    }

    public ActivityRequest(String nameAct, String userName, String action) {
        this.nameAct = nameAct;
        this.userName = userName;
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNameAct() {
        return nameAct;
    }

    public void setNameAct(String nameAct) {
        this.nameAct = nameAct;
    }

    public ActivityRequest(String nameAct) {
        this.nameAct = nameAct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
