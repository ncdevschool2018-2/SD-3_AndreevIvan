package by.training.nc.sd2.fapi.service.impl;

import by.training.nc.sd2.fapi.models.UserServiceViewModel;
import by.training.nc.sd2.fapi.service.UserServiceDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceDataServiceImpl implements UserServiceDataService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<UserServiceViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserServiceViewModel[] userServiceViewModels = restTemplate.getForObject(backendServerUrl + "/api/users-services-backend/", UserServiceViewModel[].class);
        return userServiceViewModels == null ? Collections.emptyList() : Arrays.asList(userServiceViewModels);
    }

    @Override
    public UserServiceViewModel createUserService(UserServiceViewModel userServiceViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users-services-backend/", userServiceViewModel, UserServiceViewModel.class).getBody();
    }

    @Override
    public List<UserServiceViewModel> findUserServicesById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        UserServiceViewModel[] userServiceViewModels = restTemplate.getForObject(backendServerUrl + "/api/users-services-backend/" + id, UserServiceViewModel[].class);
        return userServiceViewModels == null ? Collections.emptyList() : Arrays.asList(userServiceViewModels);
    }
}
