package by.training.nc.sd2.fapi.controller;

import by.training.nc.sd2.fapi.models.AuthInfoModel;
import by.training.nc.sd2.fapi.models.ServiceViewModel;
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
    public ResponseEntity<List<UserAccountViewModel>> getAllUserAccounts() {
        return ResponseEntity.ok(userAccountDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> createUser(@RequestBody UserAccountViewModel userAccountViewModel /*todo server validation*/) {
        if (userAccountViewModel != null) {
            return ResponseEntity.ok(userAccountDataService.createUser(userAccountViewModel));
        }
        return null;
    }
    @RequestMapping(value = "/getbydata", method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> getUserAccountByData(@RequestBody AuthInfoModel authInfoModel) {
        return ResponseEntity.ok(userAccountDataService.getUserAccountByData(authInfoModel));
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<UserAccountViewModel> setUserTokens(@RequestBody UserAccountViewModel accountViewModel){
        return ResponseEntity.ok(userAccountDataService.setUserTokens(accountViewModel));
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.GET)
    public ResponseEntity<UserAccountViewModel> getUserById(@RequestParam Long id){
        return ResponseEntity.ok(userAccountDataService.getUserById(id));
    }
    @RequestMapping(value = "/isUserExists", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isUserExists(@RequestParam String login){
        return ResponseEntity.ok(userAccountDataService.isUserExists(login));
    }
}
