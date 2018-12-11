package by.training.nc.sd2.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountViewModel {
    private int id;
    private String login;
    private String email;
    private int tokens;
    private String password;
    private String status;
    private int role;

    private List<UserServiceViewModel> userServices;

    public UserAccountViewModel() {
    }

    public List<UserServiceViewModel> getUserServices() {
        return userServices;
    }

    public void setUserServices(List<UserServiceViewModel> userServices) {
        this.userServices = userServices;
    }

    public int getTokens() {
        return tokens;
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
