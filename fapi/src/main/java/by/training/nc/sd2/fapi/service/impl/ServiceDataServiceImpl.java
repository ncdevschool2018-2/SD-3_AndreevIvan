package by.training.nc.sd2.fapi.service.impl;

import by.training.nc.sd2.fapi.models.ServiceViewModel;
import by.training.nc.sd2.fapi.service.ServiceDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ServiceDataServiceImpl implements ServiceDataService {
    @Value("http://localhost:8080/")
    private String backendServerUrl;

    @Override
    public List<ServiceViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ServiceViewModel[] serviceViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/services-backend/", ServiceViewModel[].class);
        return serviceViewModelResponse == null ? Collections.emptyList() : Arrays.asList(serviceViewModelResponse);
    }
    @Override
    public ServiceViewModel createService(ServiceViewModel service) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(service.getName());
        return restTemplate.postForEntity(backendServerUrl + "/api/services-backend/", service, ServiceViewModel.class).getBody();
    }

    @Override
    public List<ServiceViewModel> getNativeServicesFromUser(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        ServiceViewModel[] serviceViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/users-backend/getServicesFromUserByUserId/" + id, ServiceViewModel[].class);
        return serviceViewModelResponse == null ? Collections.emptyList() : Arrays.asList(serviceViewModelResponse);
    }
}
