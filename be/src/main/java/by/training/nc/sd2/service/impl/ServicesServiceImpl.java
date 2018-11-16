package by.training.nc.sd2.service.impl;

import by.training.nc.sd2.entity.Service;
import by.training.nc.sd2.reprository.ServiceReprository;
import by.training.nc.sd2.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicesServiceImpl implements ServiceService {

    private ServiceReprository reprository;

    @Autowired
    public ServicesServiceImpl(ServiceReprository reprository) {
        this.reprository = reprository;
    }

    @Override
    public Service createService(Service service) {
        return reprository.save(service);
    }

    @Override
    public Iterable<Service> getAllServices() {
        return reprository.findAll();
    }
}
