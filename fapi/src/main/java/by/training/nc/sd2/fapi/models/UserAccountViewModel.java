package by.training.nc.sd2.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccountViewModel {
    private int id;
    private String name;
    private String email;
    private int tokens;

    public UserAccountViewModel() {
    }

    public UserAccountViewModel(int id, String name, String email, int tokens) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tokens = tokens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
}
