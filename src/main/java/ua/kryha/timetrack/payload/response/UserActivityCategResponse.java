package ua.kryha.timetrack.payload.response;

import java.util.List;


public class UserActivityCategResponse {
    private List<ActivityResponse> activities;

    private String nameCategory;

    public UserActivityCategResponse(String nameCategory,List<ActivityResponse> activities) {
        this.activities = activities;
        this.nameCategory = nameCategory;
    }
}
