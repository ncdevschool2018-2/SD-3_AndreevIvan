package by.training.nc.sd2.entity;


import javax.persistence.*;

@Entity
@Table(name = "user-service-data")
public class UserService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int subVariant;


    private int daysLeft;
    private int status;
    private String name;
    private int basePrice;



    public UserService() {
    }

    public UserService(int userId, int subVariant, int daysLeft, int status, String name, int basePrice) {
        this.userId = userId;
        this.subVariant = subVariant;
        this.daysLeft = daysLeft;
        this.status = status;
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubVariant() {
        return subVariant;
    }

    public void setSubVariant(int subVariant) {
        this.subVariant = subVariant;
    }

    public int getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }
}
