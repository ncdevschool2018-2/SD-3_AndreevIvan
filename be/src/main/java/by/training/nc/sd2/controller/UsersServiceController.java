package by.training.nc.sd2.controller;


import by.training.nc.sd2.entity.UserService;
import by.training.nc.sd2.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users-services-backend/")
public class UsersServiceController {
    private UserServiceService userServiceService;

    @Autowired
    public UsersServiceController(UserServiceService userAccountService) {
        this.userServiceService = userAccountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserService> getAllServices() {
        return userServiceService.getAllUserServices();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserService createService(@RequestBody UserService userAccount) {
        return userServiceService.createUserService(userAccount);
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteService(@PathVariable(name = "id") Integer id) {
        userServiceService.deleteUserService(id);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Iterable<UserService> findUserServicesById(@PathVariable(name = "id") Integer id) {
        return userServiceService.findUserServicesByUserId(id);
    }
    @RequestMapping(value = "", params = {"status", "userId", "serviceId"}, method = RequestMethod.GET)
    public void getUserAccountByLoginAndPassword(
            @RequestParam("status") String status, @RequestParam("userId") String userId,
            @RequestParam("serviceId") String serviceId) {
        userServiceService.updateUserServiceStatus(
                Integer.parseInt(status), Integer.parseInt(userId),
                Integer.parseInt(serviceId));
    }
}
