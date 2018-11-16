package by.training.nc.sd2.service.impl;

import by.training.nc.sd2.entity.User;
import by.training.nc.sd2.reprository.UserAccountReprository;
import by.training.nc.sd2.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserAccountServiceImpl implements UserAccountService {
    private UserAccountReprository reprository;

    @Autowired
    public UserAccountServiceImpl(UserAccountReprository reprository) {
        this.reprository = reprository;
    }

    @Override
    public User createUser(User user) {
        return reprository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return reprository.findAll();
    }
}
