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

    @RequestMapping/*(method = RequestMethod.GET)*/
    public ResponseEntity<List<ServiceViewModel>> getAll() {
        //ResponseEntity<List<ServiceViewModel>> responseEntity = ResponseEntity.ok(serviceDataService.getAll());

        return ResponseEntity.ok(serviceDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ServiceViewModel> createService(@RequestBody ServiceViewModel serviceViewModel /*todo server validation*/) {
        if (serviceViewModel != null) {
            return ResponseEntity.ok(serviceDataService.createService(serviceViewModel));
        }
        return null;
    }
}
