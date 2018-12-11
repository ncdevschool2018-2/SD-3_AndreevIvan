package by.training.nc.sd2.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceViewModel {
    private int id;
    private String name;
    private String description;
    private String basePrice;

    private List<UserServiceViewModel> userServices;

    public ServiceViewModel(){

    }

    public List<UserServiceViewModel> getUserServices() {
        return userServices;
    }

    public void setUserServices(List<UserServiceViewModel> userServices) {
        this.userServices = userServices;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
