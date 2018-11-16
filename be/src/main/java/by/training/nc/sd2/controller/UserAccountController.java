package by.training.nc.sd2.controller;

import by.training.nc.sd2.entity.User;
import by.training.nc.sd2.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users-backend/")
public class UserAccountController {
    private UserAccountService serviceService;

    @Autowired
    public UserAccountController(UserAccountService serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<User> getAllServices() {
        return serviceService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createService(@RequestBody User user) {
        return serviceService.createUser(user);
    }
}
