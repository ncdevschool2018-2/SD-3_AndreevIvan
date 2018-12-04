package by.training.nc.sd2.reprository;


import by.training.nc.sd2.entity.UserService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserServiceRepository extends CrudRepository<UserService, Integer> {
    Iterable<UserService> findUserServicesByUserId(Integer id);
    //Iterable<UserService> findByUserId(Integer id);

    /*@Query( value = "SELECT * FROM user_service_data WHERE userId = 1",
            nativeQuery = true)
    Iterable<UserService> findUserServicesByUserId(@Param("userId") Long id);*/
}
