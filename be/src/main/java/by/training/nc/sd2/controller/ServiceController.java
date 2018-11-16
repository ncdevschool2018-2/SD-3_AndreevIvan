package by.training.nc.sd2.controller;


import by.training.nc.sd2.entity.Service;
import by.training.nc.sd2.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
        return serviceService.getAllServices();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Service createService(@RequestBody Service service) {
        return serviceService.createService(service);
    }
}
