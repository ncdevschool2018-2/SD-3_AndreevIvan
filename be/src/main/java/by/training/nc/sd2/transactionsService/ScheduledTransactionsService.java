package by.training.nc.sd2.transactionsService;


import by.training.nc.sd2.entity.Service;
import by.training.nc.sd2.entity.UserAccount;
import by.training.nc.sd2.entity.UserService;
import by.training.nc.sd2.service.UserAccountService;
import by.training.nc.sd2.service.UserServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class ScheduledTransactionsService {

    public static final int ACTIVE = 1;
    public static final int BANNED = 2;

    private UserAccountService userAccountService;
    private UserServiceService userServiceService;

    @Autowired
    public ScheduledTransactionsService (UserAccountService userAccountService,
                                         UserServiceService userServiceService) {
        this.userAccountService = userAccountService;
        this.userServiceService = userServiceService;
    }
    @Transactional
    @Scheduled(cron="*/5 * * * * *")
    public void calculateTransactions(){
        Iterable<UserService> userServicesData = userServiceService.getAllUserServices();
        userServicesData.forEach(userServicesDataUnit -> {
            Optional<UserAccount> userAccount =
                    userAccountService.getUserAccountById(userServicesDataUnit.getUserId());
            //userAccount.ifPresent(theUser -> {
            //    if (theUser.getTokens() >= (userServicesDataUnit.getBasePrice() * userServicesDataUnit.getSubVariant())) {
            //        userServicesDataUnit.setStatus(ACTIVE);
            //        userAccountService.updateUserAccount(theUser);
            //    }
            //});
            if(userServicesDataUnit.getStatus() == ACTIVE) {
                if (userServicesDataUnit.getDaysLeft() == 0) {
                    userAccount.ifPresent(theUser -> {
                        if (theUser.getTokens() >= (userServicesDataUnit.getBasePrice() * userServicesDataUnit.getSubVariant())) {
                            theUser.setTokens(theUser.getTokens() - userServicesDataUnit.getBasePrice() * userServicesDataUnit.getSubVariant());
                            userAccountService.updateUserAccount(theUser);
                        } else {
                            userServicesDataUnit.setStatus(BANNED);
                            userServiceService.updateUserService(userServicesDataUnit);
                        }
                    });
                    if (userServicesDataUnit.getStatus() == ACTIVE) {
                        userServicesDataUnit.setDaysLeft(userServicesDataUnit.getSubPeriod());
                        userServiceService.updateUserService(userServicesDataUnit);
                    }
                }
            }
            if(userServicesDataUnit.getDaysLeft() > 0){
                userServicesDataUnit.setDaysLeft(userServicesDataUnit.getDaysLeft() - 1);
                userServiceService.updateUserService(userServicesDataUnit);
            }
        });
    }
}
