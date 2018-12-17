package by.training.nc.sd2.controller;

import by.training.nc.sd2.entity.Service;
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
    public Iterable<UserAccount> getAllUsers() {
        return userAccountService.getAllUserAccounts();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserAccount createService(@RequestBody UserAccount userAccount) {
        return userAccountService.createUserAccount(userAccount);
    }
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public Optional<UserAccount> getUserAccountByLoginAndPassword(@RequestBody AuthInfo authInfo) {
        Optional<UserAccount> userAccount = userAccountService.getUserAccount(authInfo.login, authInfo.password);
        return userAccountService.getUserAccount(authInfo.login, authInfo.password);
    }
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public UserAccount setUserTokens(@RequestBody UserAccount userAccount) {
        return userAccountService.setUserTokens(userAccount);
    }
    @RequestMapping(value = "", params = {"id"}, method = RequestMethod.GET)
    public Optional<UserAccount> getUserAccountById(@RequestParam("id") Integer id) {
        return userAccountService.getUserAccountById(id);
    }
    @RequestMapping(value = "/isUserExists", params = {"login"}, method = RequestMethod.GET)
    public Boolean isUserExists(@RequestParam("login") String login) {
        Boolean isExists = userAccountService.isUserExists(login);
        return userAccountService.isUserExists(login);
    }
}
class AuthInfo {
    public String login;
    public String password;
}
