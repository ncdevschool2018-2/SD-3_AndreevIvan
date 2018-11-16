package by.training.nc.sd2.fapi.controller;

import by.training.nc.sd2.fapi.models.ServiceViewModel;
import by.training.nc.sd2.fapi.service.ServiceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceDataController {
    @Autowired
    private ServiceDataService serviceDataService;

    @RequestMapping
    public ResponseEntity<List<ServiceViewModel>> getAll() {
        return ResponseEntity.ok(serviceDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ServiceViewModel> createService(@RequestBody ServiceViewModel service /*todo server validation*/) {
        if (service != null) {
            return ResponseEntity.ok(serviceDataService.createService(service));
        }
        return null;
    }
}
