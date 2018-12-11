package by.training.nc.sd2.fapi.service;

import by.training.nc.sd2.fapi.models.UserServiceViewModel;

import java.util.List;

public interface UserServiceDataService {
    List<UserServiceViewModel> findUserServicesById(Long id);
    List<UserServiceViewModel> getAll();
    UserServiceViewModel createUserService(UserServiceViewModel account);
    void deleteUserService(Long id);

}
