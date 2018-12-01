package by.training.nc.sd2.reprository;


import by.training.nc.sd2.entity.UserService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserServiceRepository extends CrudRepository<UserService, Integer> {
    Iterable<UserService> findUserServicesByUserId(Integer id);
}
