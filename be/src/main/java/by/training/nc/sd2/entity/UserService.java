package by.training.nc.sd2.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_service_data")
public class UserService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int subVariant;

    private int subPeriod;
    private int daysLeft;
    private int status;
    private String name;
    private int basePrice;



    public UserService() {
    }

    public UserService(int userId, int subVariant, int subPeriod,
                       int daysLeft, int status, String name, int basePrice) {
        this.userId = userId;
        this.subVariant = subVariant;
        this.subPeriod = subPeriod;
        this.daysLeft = daysLeft;
        this.status = status;
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getSubPeriod() {
        return subPeriod;
    }

    public void setSubPeriod(int subPeriod) {
        this.subPeriod = subPeriod;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserService that = (UserService) o;
        return userId == that.userId &&
                subVariant == that.subVariant &&
                daysLeft == that.daysLeft &&
                status == that.status &&
                basePrice == that.basePrice &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, subVariant, daysLeft, status, name, basePrice);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "id=" + id +
                ", userId=" + userId +
                ", subVariant=" + subVariant +
                ", daysLeft=" + daysLeft +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
