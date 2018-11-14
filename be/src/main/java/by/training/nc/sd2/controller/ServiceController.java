package by.training.nc.sd2.controller;


import by.training.nc.sd2.entity.Service;
import by.training.nc.sd2.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/services-backend/")
public class ServiceController {
    private ServiceService billingAccountService;

    @Autowired
    public ServiceController(ServiceService billingAccountService) {
        this.billingAccountService = billingAccountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Service> getAllServices() {
        return billingAccountService.getAllServices();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Service createService(@RequestBody Service account) {
        return billingAccountService.createService(account);
    }
}
