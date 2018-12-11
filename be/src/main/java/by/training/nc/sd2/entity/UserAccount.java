package by.training.nc.sd2.entity;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String login;
    private String email;
    private int tokens;
    private String password;
    private String status;
    private int role;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserService> userServices = new ArrayList<>();

    public UserAccount() {
    }

    public UserAccount(String login, String email, int tokens,
                       String password, String status, int role, List<UserService> userServices) {
        this.login = login;
        this.email = email;
        this.tokens = tokens;
        this.password = password;
        this.status = status;
        this.role = role;
        this.userServices = userServices;
    }

    public List<UserService> getUserServices() {
        return userServices;
    }

    public void setUserServices(List<UserService> userServices) {
        this.userServices = userServices;
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

    public int getTokens() {
        return tokens;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return id == that.id &&
                tokens == that.tokens &&
                role == that.role &&
                Objects.equals(login, that.login) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email, tokens, password, status, role);
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", tokens=" + tokens +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", role=" + role +
                ", userServices=" + userServices.size() +
                '}';
    }
}
