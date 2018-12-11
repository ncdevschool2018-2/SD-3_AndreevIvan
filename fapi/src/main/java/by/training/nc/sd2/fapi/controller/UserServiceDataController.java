package by.training.nc.sd2.fapi.controller;


import by.training.nc.sd2.fapi.models.UserServiceViewModel;
import by.training.nc.sd2.fapi.service.UserServiceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userService")
public class UserServiceDataController {

    @Autowired
    private UserServiceDataService userServiceDataService;

    @RequestMapping
    public ResponseEntity<List<UserServiceViewModel>> getAllBillingAccounts() {
        return ResponseEntity.ok(userServiceDataService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<UserServiceViewModel>> findUserServicesById(@PathVariable Long id){
        return ResponseEntity.ok(userServiceDataService.findUserServicesById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserServiceViewModel> createUserService(@RequestBody UserServiceViewModel userServiceViewModel /*todo server validation*/) {
        if (userServiceViewModel != null) {
            return ResponseEntity.ok(userServiceDataService.createUserService(userServiceViewModel));
        }
        return null;
    }
    @RequestMapping(value = "/deleteuserservice/{id}", method = RequestMethod.DELETE)
    public void deleteUserService(@PathVariable String id) {
        userServiceDataService.deleteUserService(Long.valueOf(id));
    }

}
