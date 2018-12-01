package by.training.nc.sd2.service.impl;

import by.training.nc.sd2.entity.UserAccount;
import by.training.nc.sd2.reprository.UserAccountRepository;
import by.training.nc.sd2.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserAccountServiceImpl implements UserAccountService {
    private UserAccountRepository reprository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository reprository) {
        this.reprository = reprository;
    }

    @Override
    public UserAccount createUserAccount(UserAccount userAccount) {
        return reprository.save(userAccount);
    }

    @Override
    public Iterable<UserAccount> getAllUserAccounts() {
        return reprository.findAll();
    }
}
