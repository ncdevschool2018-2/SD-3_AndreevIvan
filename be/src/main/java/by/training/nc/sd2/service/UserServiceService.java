package by.training.nc.sd2.service;

import by.training.nc.sd2.entity.UserService;

import java.util.List;

public interface UserServiceService {
    UserService createUserService(UserService service);
    Iterable<UserService> getAllUserServices();
    void updateUserService(UserService service);
    Iterable<UserService> findUserServicesByUserId(Integer id);
    void deleteUserService(Integer id);
}
