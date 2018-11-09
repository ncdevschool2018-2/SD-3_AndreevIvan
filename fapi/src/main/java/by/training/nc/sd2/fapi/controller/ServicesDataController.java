package by.training.nc.sd2.fapi.controller;

import by.training.nc.sd2.fapi.models.ServicesViewModel;
import by.training.nc.sd2.fapi.service.ServicesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesDataController {
    @Autowired
    private ServicesDataService servicesDataService;

    @RequestMapping
    public ResponseEntity<List<ServicesViewModel>> getAllBillingAccounts() {
        return ResponseEntity.ok(servicesDataService.getAll());
    }
}
