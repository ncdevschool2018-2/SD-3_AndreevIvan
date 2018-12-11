package by.training.nc.sd2.fapi.controller;

import by.training.nc.sd2.fapi.models.ServiceViewModel;
import by.training.nc.sd2.fapi.service.ServiceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceDataController {
    @Autowired
    private ServiceDataService serviceDataService;

    @RequestMapping/*(method = RequestMethod.GET)*/
    public ResponseEntity<List<ServiceViewModel>> getAll() {
        ResponseEntity<List<ServiceViewModel>> responseEntity = ResponseEntity.ok(serviceDataService.getAll());

        return ResponseEntity.ok(serviceDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ServiceViewModel> createService(@RequestBody ServiceViewModel serviceViewModel /*todo server validation*/) {
        if (serviceViewModel != null) {
            return ResponseEntity.ok(serviceDataService.createService(serviceViewModel));
        }
        return null;
    }
    @RequestMapping(value = "/getServicesFromUserByUserId/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<ServiceViewModel>> getNativeServicesFromUser(@PathVariable Integer id) {
        return ResponseEntity.ok(serviceDataService.getNativeServicesFromUser(id));
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteService(@PathVariable String id) {
        serviceDataService.deleteService(Long.valueOf(id));
    }
}
