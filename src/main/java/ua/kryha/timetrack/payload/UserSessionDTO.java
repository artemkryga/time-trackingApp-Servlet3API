package ua.kryha.timetrack.payload;

import ua.kryha.timetrack.model.ERole;

public class UserSessionDTO {

    private String username;
    private String email;
    private ERole role;

    public UserSessionDTO(String username, String email, ERole role) {
        this.username = username;
        this.email = email;
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
