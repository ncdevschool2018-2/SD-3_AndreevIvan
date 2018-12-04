package by.training.nc.sd2.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountViewModel {
    private int id;
    private String login;
    private String email;
    private int tokens;
    private String password;
    private String status;
    private int role;

    public UserAccountViewModel() {
    }

    public int getTokens() {
        return tokens;
    }

    public UserAccountViewModel(int id, String login, String email, int tokens,
                                String password, String status, int role) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.tokens = tokens;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
