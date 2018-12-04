package by.training.nc.sd2.controller;

import by.training.nc.sd2.entity.UserAccount;
import by.training.nc.sd2.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users-backend/")
public class UserAccountController {
    private UserAccountService userAccountService;

    @Autowired
    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserAccount> getAllServices() {
        return userAccountService.getAllUserAccounts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserAccount createService(@RequestBody UserAccount userAccount) {
        return userAccountService.createUserAccount(userAccount);
    }
    @RequestMapping(value = "", params = {"login", "password"}, method = RequestMethod.GET)
    public Optional<UserAccount> getUserAccountByLoginAndPassword(
            @RequestParam("login") String login, @RequestParam("password") String password) {
        //return userAccountService.getUserAccount("petya", "846513");
        return userAccountService.getUserAccount(login, password);
    }
    @RequestMapping(value = "/setTokens", method = RequestMethod.POST)
    public UserAccount setUserTokens(@RequestBody UserAccount userAccount) {
        return userAccountService.setUserTokens(userAccount);
    }
    @RequestMapping(value = "", params = {"id"}, method = RequestMethod.GET)
    public Optional<UserAccount> getUserAccountById(@RequestParam("id") Integer id) {
        //return userAccountService.getUserAccount("petya", "846513");
        return userAccountService.getUserAccountById(id);
    }

}
