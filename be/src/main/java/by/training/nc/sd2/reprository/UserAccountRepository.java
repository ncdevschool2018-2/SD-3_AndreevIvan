package by.training.nc.sd2.reprository;


import by.training.nc.sd2.entity.UserAccount;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;
import java.util.Optional;


@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
    Optional<UserAccount> findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
    Optional<UserAccount> findUserAccountById(@Param("id") Integer id);
    /*@Modifying
    @Query("UPDATE UserAccount u SET u.tokens = :tokens WHERE u.id = :id")
    Optional<Long> setUserTokens(@Param("id")Long id, @Param("tokens") Long tokens);
    */
}