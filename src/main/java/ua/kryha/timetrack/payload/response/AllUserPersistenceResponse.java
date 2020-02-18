package ua.kryha.timetrack.payload.response;

import java.util.List;


public class AllUserPersistenceResponse {


    private String userName;

    private List<PersistenceResponse> activities;

    public AllUserPersistenceResponse(String userName, List<PersistenceResponse> activities) {
        this.userName = userName;
        this.activities = activities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<PersistenceResponse> getActivities() {
        return activities;
    }

    public void setActivities(List<PersistenceResponse> activities) {
        this.activities = activities;
    }


}
