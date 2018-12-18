package by.training.nc.sd2.fapi.service.impl;

import by.training.nc.sd2.fapi.models.AuthInfoModel;
import by.training.nc.sd2.fapi.models.UserAccountViewModel;
import by.training.nc.sd2.fapi.service.UserAccountDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
    public UserAccountViewModel createUser(UserAccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users-backend/", account, UserAccountViewModel.class)
                .getBody();
    }

    @Override
    public void deleteUserAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/users-backend/" + id);
    }

    @Override
    public UserAccountViewModel getUserAccountByData(AuthInfoModel authInfoModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "api/users-backend/getUser", authInfoModel, UserAccountViewModel.class)
                .getBody();
    }

    @Override
    public UserAccountViewModel setUserTokens(UserAccountViewModel account) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users-backend/updateUser",
                account, UserAccountViewModel.class).getBody();
    }

    @Override
    public UserAccountViewModel getUserById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "api/users-backend/?id=" + id,
                UserAccountViewModel.class, id);
    }

    @Override
    public Boolean isUserExists(String login) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "api/users-backend/isUserExists/?login=" + login,
                Boolean.class, login);
    }
}
