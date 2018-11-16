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
        RestTemplate restTemplate = new RestTemplate();
        UserAccountViewModel[] billingAccountViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/users-backend/", UserAccountViewModel[].class);
        return billingAccountViewModelResponse == null ? Collections.emptyList() : Arrays.asList(billingAccountViewModelResponse);
    }

    @Override
    public UserAccountViewModel getBillingAccountById(Long id) {
        return null;
    }

    @Override
    public UserAccountViewModel createUser(UserAccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users-backend/", account, UserAccountViewModel.class).getBody();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/billing-accounts/" + id);
    }
}
