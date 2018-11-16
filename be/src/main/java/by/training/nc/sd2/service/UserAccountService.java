package by.training.nc.sd2.service;

import by.training.nc.sd2.entity.User;

public interface UserAccountService {
    User createUser(User service);
    Iterable<User> getAllUsers();
}
