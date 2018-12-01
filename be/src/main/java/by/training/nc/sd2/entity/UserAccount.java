package by.training.nc.sd2.entity;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String email;
    private int tokens;
    private String password;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "users-services",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "serviceId"))
    Set<Service> havingServices;



    public UserAccount() {
    }

    public UserAccount(String login, String email, int tokens, String password, String status) {
        this.login = login;
        this.email = email;
        this.tokens = tokens;
        this.password = password;
        this.status = status;
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
    public int hashCode() {

        return Objects.hash(id, login, email, tokens);
    }

    @Override
    public String toString() {
        return "BillingAccount{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", tokens='" + tokens + '\'' +
                ", password='" + password+ '\'' +
                '}';
    }
}
