package ua.kryha.timetrack.payload.response;

import java.util.List;


public class UserActivityCategResponse {

    private List<ActivityResponse> activities;

    private String nameCategory;

    public UserActivityCategResponse(String nameCategory,List<ActivityResponse> activities) {
        this.activities = activities;
        this.nameCategory = nameCategory;
    }

    public List<ActivityResponse> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityResponse> activities) {
        this.activities = activities;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
