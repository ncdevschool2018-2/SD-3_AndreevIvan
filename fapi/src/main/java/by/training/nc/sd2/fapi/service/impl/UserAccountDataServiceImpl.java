package by.training.nc.sd2.fapi.service.impl;

import by.training.nc.sd2.fapi.models.UserAccountViewModel;
import by.training.nc.sd2.fapi.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserAccountDataServiceImpl implements UserAccountDataService {

    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<UserAccountViewModel> getAll() {
        List<UserAccountViewModel> usersList = new ArrayList<>();
        UserAccountViewModel user1 = new UserAccountViewModel(1, "Eduard", "eduard@gmail.com", 156);
        UserAccountViewModel user2 = new UserAccountViewModel(2, "Aleksandr", "eduard@gmail.com", 156);
        UserAccountViewModel user3 = new UserAccountViewModel(3, "Aleksandra", "eduard@gmail.com", 156);
        UserAccountViewModel user4 = new UserAccountViewModel(4, "AMELIE", "eduard@gmail.com", 156);
        UserAccountViewModel user5 = new UserAccountViewModel(5, "HARRIET", "eduard@gmail.com", 156);
        UserAccountViewModel user6 = new UserAccountViewModel(6, "IVY", "eduard@gmail.com", 156);
        UserAccountViewModel user7 = new UserAccountViewModel(7, "JAMIE", "eduard@gmail.com", 156);
        UserAccountViewModel user8 = new UserAccountViewModel(8, "CALLUM", "eduard@gmail.com", 156);
        UserAccountViewModel user9 = new UserAccountViewModel(9, "LOUIS", "eduard@gmail.com", 156);
        UserAccountViewModel user10 = new UserAccountViewModel(10, "THEODORE", "eduard@gmail.com", 156);
        UserAccountViewModel user11 = new UserAccountViewModel(11, "EduGABRIEL", "eduard@gmail.com", 156);

        usersList.add(user1);
        usersList.add(user2);
        usersList.add(user3);
        usersList.add(user4);
        usersList.add(user5);
        usersList.add(user6);
        usersList.add(user7);
        usersList.add(user8);
        usersList.add(user9);
        usersList.add(user10);
        usersList.add(user11);

        return usersList;

        /*RestTemplate restTemplate = new RestTemplate();
        UserAccountViewModel[] billingAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/billing-accounts/", UserAccountViewModel[].class);
        return billingAccountViewModelResponse == null ? Collections.emptyList() : Arrays.asList(billingAccountViewModelResponse);*/
    }

    @Override
    public UserAccountViewModel getBillingAccountById(Long id) {
        return null;
    }

    @Override
    public UserAccountViewModel saveBillingAccount(UserAccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/billing-accounts", account, UserAccountViewModel.class).getBody();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/billing-accounts/" + id);
    }
}
