package by.training.nc.sd2.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserServiceViewModel {

    private int id;
    private int userId;
    private int subVariant;

    private int subPeriod;
    private int daysLeft;
    private int status;
    private String name;
    private int basePrice;

    public UserServiceViewModel() {
    }

    public UserServiceViewModel(int id, int userId, int subVariant, int subPeriod,
                                int daysLeft, int status, String name, int basePrice) {
        this.id = id;
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

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
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

}
