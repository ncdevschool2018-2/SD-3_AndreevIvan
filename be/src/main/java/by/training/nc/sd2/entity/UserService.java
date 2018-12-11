package by.training.nc.sd2.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_service_data")
public class UserService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="user_id")
    private int userId;
    @Column(name="service_id")
    private int serviceId;
    @Column(name="sub_variant")
    private int subVariant;
    @Column(name="sub_period")
    private int subPeriod;
    @Column(name="days_left")
    private int daysLeft;
    private int status;
    private String name;
    @Column(name="base_price")
    private int basePrice;


    public UserService() {
    }

    public UserService(int userId, int serviceId, int subVariant,
                       int subPeriod, int daysLeft, int status, String name, int basePrice) {
        this.userId = userId;
        this.serviceId = serviceId;
        this.subVariant = subVariant;
        this.subPeriod = subPeriod;
        this.daysLeft = daysLeft;
        this.status = status;
        this.name = name;
        this.basePrice = basePrice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
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
                serviceId == that.serviceId &&
                subVariant == that.subVariant &&
                subPeriod == that.subPeriod &&
                daysLeft == that.daysLeft &&
                status == that.status &&
                basePrice == that.basePrice &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, serviceId, subVariant, subPeriod, daysLeft, status, name, basePrice);
    }

    @Override
    public String toString() {
        return "UserService{" +
                "id=" + id +
                ", userId=" + userId +
                ", serviceId=" + serviceId +
                ", subVariant=" + subVariant +
                ", subPeriod=" + subPeriod +
                ", daysLeft=" + daysLeft +
                ", status=" + status +
                ", name='" + name + '\'' +
                ", basePrice=" + basePrice +
                '}';
    }
}
