package by.training.nc.sd2.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String basePrice;

    @ManyToMany(mappedBy = "havingServices")
    Set<UserAccount> followedUserAccounts;

    public Service(){

    }



    public Service(String name, String description, String basePrice) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
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
        Service that = (Service) o;
        return  Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(basePrice, that.basePrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, basePrice);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", basePrice='" + basePrice + '\'' +
                '}';
    }
}
