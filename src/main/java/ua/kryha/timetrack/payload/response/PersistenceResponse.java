package ua.kryha.timetrack.payload.response;


import ua.kryha.timetrack.model.EUserAction;

public class PersistenceResponse {
    private String nameAct;

    private EUserAction action;

    public PersistenceResponse(String nameAct, EUserAction action) {
        this.nameAct = nameAct;
        this.action = action;
    }
}
