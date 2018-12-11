package by.training.nc.sd2.entity;

import org.apache.catalina.User;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    private String name;
    private String description;
    private String basePrice;

    @OneToMany
    @JoinColumn(name = "service_id")
    private List<UserService> userServices = new ArrayList<>();

    public Service(){

    }

    public Service(String name, String description, String basePrice, List<UserService> userServices) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
        this.userServices = userServices;
    }

    public List<UserService> getUserServices() {
        return userServices;
    }

    public void setUserServices(List<UserService> userServices) {
        this.userServices = userServices;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return id == service.id &&
                Objects.equals(name, service.name) &&
                Objects.equals(description, service.description) &&
                Objects.equals(basePrice, service.basePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, basePrice);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", basePrice='" + basePrice + '\'' +
                ", userServices=" + userServices.size() +
                '}';
    }
}
