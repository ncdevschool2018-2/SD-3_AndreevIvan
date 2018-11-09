package by.training.nc.sd2.fapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import by.training.nc.sd2.fapi.models.UserAccountViewModel;
import by.training.nc.sd2.fapi.service.UserAccountDataService;

@RestController
@RequestMapping("/api/user")
public class UserAccountDataController {

    @Autowired
    private UserAccountDataService userAccountDataService;

    @RequestMapping
    public ResponseEntity<List<UserAccountViewModel>> getAllBillingAccounts() {
        return ResponseEntity.ok(userAccountDataService.getAll());
    }

}