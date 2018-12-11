package by.training.nc.sd2.controller;


import by.training.nc.sd2.entity.Service;
import by.training.nc.sd2.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;


@RestController
@RequestMapping("/api/services-backend/")
public class ServiceController {
    private ServiceService serviceService;

    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Service> getAllServices() {

        Iterable<Service> services = serviceService.getAllServices();
        return serviceService.getAllServices();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Service createService(@RequestBody Service service) {
        return serviceService.createService(service);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteService(@PathVariable(name = "id") Integer id) {
        serviceService.deleteService(id);
    }
}
