package by.training.nc.sd2.service;

import by.training.nc.sd2.entity.UserAccount;

import java.util.Optional;

public interface UserAccountService {
    UserAccount createUserAccount(UserAccount service);
    Iterable<UserAccount> getAllUserAccounts();
    Optional<UserAccount> getUserAccount(String name, String password);
    UserAccount setUserTokens(UserAccount userAccount);
    Optional<UserAccount> getUserAccountById(Integer id);
}
