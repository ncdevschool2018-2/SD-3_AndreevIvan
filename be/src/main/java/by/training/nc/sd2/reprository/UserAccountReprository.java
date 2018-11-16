package by.training.nc.sd2.reprository;


import by.training.nc.sd2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserAccountReprository extends CrudRepository<User, Long> {
}
