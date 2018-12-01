package by.training.nc.sd2.service;

import by.training.nc.sd2.entity.UserAccount;

public interface UserAccountService {
    UserAccount createUserAccount(UserAccount service);
    Iterable<UserAccount> getAllUserAccounts();
}
