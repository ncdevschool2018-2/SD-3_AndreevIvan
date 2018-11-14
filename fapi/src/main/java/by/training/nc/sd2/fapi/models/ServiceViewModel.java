package by.training.nc.sd2.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceViewModel {
    private int id;
    private String name;
    private String description;
    private String basePrice;
    private String status;

    public int getId() {
        return id;
    }

    public ServiceViewModel(){

    }

    public ServiceViewModel(int id, String name, String basePrice, String description, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
