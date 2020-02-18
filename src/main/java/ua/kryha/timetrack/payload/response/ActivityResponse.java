package ua.kryha.timetrack.payload.response;

public class ActivityResponse {

    private Integer id;

    private String nameAct;

    private String nameCateg;

    private Boolean userHas = false;

    private String status;

    public ActivityResponse() {
    }

    public ActivityResponse(String nameAct, String nameCateg) {
        this.nameAct = nameAct;
        this.nameCateg = nameCateg;
    }

    public ActivityResponse(Integer id, String nameAct, String nameCateg) {
        this.id = id;
        this.nameAct = nameAct;
        this.nameCateg = nameCateg;
    }

    public Boolean getUserHas() {
        return userHas;
    }

    public void setUserHas(Boolean userHas) {
        this.userHas = userHas;
    }

    public String getNameAct() {
        return nameAct;
    }

    public void setNameAct(String nameAct) {
        this.nameAct = nameAct;
    }

    public String getNameCateg() {
        return nameCateg;
    }

    public void setNameCateg(String nameCateg) {
        this.nameCateg = nameCateg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
