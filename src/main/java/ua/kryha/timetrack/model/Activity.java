package ua.kryha.timetrack.model;

public class Activity {

    private Integer id;

    private String name;

    private Category category;

    public Activity(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public Activity() {
    }

    public Activity(Integer id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Activity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Activity(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
