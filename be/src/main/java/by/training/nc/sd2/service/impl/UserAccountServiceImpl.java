package by.training.nc.sd2.service.impl;

import by.training.nc.sd2.entity.UserAccount;
import by.training.nc.sd2.reprository.UserAccountRepository;
import by.training.nc.sd2.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


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

    @Override
    public Optional<UserAccount> getUserAccount(String login, String password) {
        Optional<UserAccount> account = this.reprository.findByLoginAndPassword(login, password);
        return account;
    }

    @Override
    public UserAccount setUserTokens(UserAccount userAccount) {
        return this.reprository.save(userAccount);
    }

    @Override
    public Optional<UserAccount> getUserAccountById(Integer id) {
        return this.reprository.findUserAccountById(id);
    }
}
