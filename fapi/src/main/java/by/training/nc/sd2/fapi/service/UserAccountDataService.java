package by.training.nc.sd2.fapi.service;

import by.training.nc.sd2.fapi.models.UserAccountViewModel;

import java.util.List;

public interface UserAccountDataService {
    List<UserAccountViewModel> getAll();
    UserAccountViewModel getBillingAccountById(Long id);
    UserAccountViewModel createUser(UserAccountViewModel account);
    void deleteBillingAccount(Long id);
}
