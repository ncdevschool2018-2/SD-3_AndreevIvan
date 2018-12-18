package by.training.nc.sd2.service.impl;

import by.training.nc.sd2.entity.UserService;
import by.training.nc.sd2.reprository.UserServiceRepository;
import by.training.nc.sd2.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Component
public class UserServiceServiceImpl implements UserServiceService {
    private UserServiceRepository reprository;

    @Autowired
    public UserServiceServiceImpl (UserServiceRepository reprository) {
        this.reprository = reprository;
    }

    @Override
    public UserService createUserService(UserService userService) {
        return reprository.save(userService);
    }

    @Override
    public Iterable<UserService> getAllUserServices() {
        return reprository.findAll();
    }

    @Override
    public void updateUserService(UserService service) {
        reprository.save(service);
    }

    @Override
    public void deleteUserService(Integer id) {
        reprository.deleteById(id);
    }
    @Override
    public Iterable<UserService> findUserServicesByUserId(Integer id){
        return reprository.findByUserId(id);
    }
    @Override
    public void updateUserServiceStatus(Integer status, Integer userId, Integer serviceId) {
        reprository.updateUserServiceStatus(status, userId, serviceId);
    }
}
