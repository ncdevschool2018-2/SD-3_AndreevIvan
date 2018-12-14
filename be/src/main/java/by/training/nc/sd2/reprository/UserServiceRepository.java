package by.training.nc.sd2.reprository;

import by.training.nc.sd2.entity.UserService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserServiceRepository extends CrudRepository<UserService, Integer> {
    Iterable<UserService> findByUserId(Integer id);
    @Transactional
    @Modifying
    @Query(value = "update UserService us set us.status = :status where us.userId = :userId and us.serviceId = :serviceId")
    void updateUserServiceStatus(@Param("status") Integer status, @Param("userId") Integer userId,
                                 @Param("serviceId") Integer serviceId);
    /*@Query( value = "SELECT * FROM user_service_data WHERE userId = 1",
            nativeQuery = true)
    Iterable<UserService> findUserServicesByUserId(@Param("userId") Long id);*/
}
