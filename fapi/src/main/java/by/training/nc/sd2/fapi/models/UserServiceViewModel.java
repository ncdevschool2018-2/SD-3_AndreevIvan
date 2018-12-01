package by.training.nc.sd2.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserServiceViewModel {

    private int daysLeft;
    private int status;
    private String name;
    private int basePrice;

    public UserServiceViewModel() {
    }

    public UserServiceViewModel(int daysLeft, int status, String name, int basePrice) {
        this.daysLeft = daysLeft;
        this.status = status;
        this.name = name;
        this.basePrice = basePrice;
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
        UserServiceViewModel that = (UserServiceViewModel) o;
        return daysLeft == that.daysLeft &&
                basePrice == that.basePrice &&
                Objects.equals(status, that.status) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(daysLeft, status, name, basePrice);
    }
}
