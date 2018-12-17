package by.training.nc.sd2.fapi.service;

import by.training.nc.sd2.fapi.models.AuthInfoModel;
import by.training.nc.sd2.fapi.models.UserAccountViewModel;

import java.util.List;

public interface UserAccountDataService {
    List<UserAccountViewModel> getAll();
    UserAccountViewModel getBillingAccountById(Long id);
    UserAccountViewModel createUser(UserAccountViewModel account);
    UserAccountViewModel getUserAccountByData(AuthInfoModel authInfoModel);
    void deleteUserAccount(Long id);
    UserAccountViewModel setUserTokens(UserAccountViewModel account);
    UserAccountViewModel getUserById(Long id);
    Boolean isUserExists(String login);
}
