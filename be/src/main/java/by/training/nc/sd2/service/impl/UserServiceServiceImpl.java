package by.training.nc.sd2.service.impl;

import by.training.nc.sd2.entity.UserService;
import by.training.nc.sd2.reprository.UserServiceRepository;
import by.training.nc.sd2.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
    public Iterable<UserService> findUserServicesByUserId(Integer id){
        Integer id2 = id;
        System.out.println(id);
        Iterable<UserService> userServices = reprository.findUserServicesByUserId(id);
        int i = 0;
        return reprository.findUserServicesByUserId(id);
    }
}
