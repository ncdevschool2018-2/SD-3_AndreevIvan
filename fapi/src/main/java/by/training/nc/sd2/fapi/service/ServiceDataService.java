package by.training.nc.sd2.fapi.service;

import by.training.nc.sd2.fapi.models.ServiceViewModel;

import java.util.List;

public interface ServiceDataService {
    List<ServiceViewModel> getAll();
    ServiceViewModel createService(ServiceViewModel account);
    List<ServiceViewModel> getNativeServicesFromUser(Integer id);
}
