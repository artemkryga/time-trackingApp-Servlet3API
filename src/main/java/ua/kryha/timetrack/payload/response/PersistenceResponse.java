package ua.kryha.timetrack.payload.response;


import ua.kryha.timetrack.model.EUserAction;

public class PersistenceResponse {

    private Integer id;

    private String nameAct;

    private EUserAction action;

    public PersistenceResponse(String nameAct, EUserAction action) {
        this.nameAct = nameAct;
        this.action = action;
    }

    public PersistenceResponse(Integer id, String nameAct, EUserAction action) {
        this.id = id;
        this.nameAct = nameAct;
        this.action = action;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameAct() {
        return nameAct;
    }

    public void setNameAct(String nameAct) {
        this.nameAct = nameAct;
    }

    public EUserAction getAction() {
        return action;
    }

    public void setAction(EUserAction action) {
        this.action = action;
    }
}
