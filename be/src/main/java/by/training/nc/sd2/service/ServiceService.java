package by.training.nc.sd2.service;

import by.training.nc.sd2.entity.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface ServiceService {
    Service createService(Service service);
    Iterable<Service> getAllServices();
    void deleteService(Integer id);
}
