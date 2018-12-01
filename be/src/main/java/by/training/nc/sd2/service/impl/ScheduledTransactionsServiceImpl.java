package by.training.nc.sd2.service.impl;

import by.training.nc.sd2.service.ScheduledTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class ScheduledTransactionsServiceImpl  implements ScheduledTransactionsService {
//    public Iterable<UserService> getAllUsersServices() {
//        return scheduledTransactionsService.getAllUsersServices();
//    }
//    @Scheduled(cron="*/5 * * * * *")
//    public void calculateTransactions() {
//        Iterable<UserService> us = getAllUsersServices();
//        //Collection userServices = (ArrayList)makeCollection(getAllUsersServices());
//        log.info("transaction started");
//        for (int i = 0; i < userServices.size(); i++){
//            UserService currentUserService;
//            currentUserService = (UserService) ((ArrayList) userServices).get(i);
//            if(Integer.parseInt(currentUserService.getDaysLeft()) != 0){
//                log.info("in subscribition " + currentUserService.getServiceId()
//                        + "of user " + currentUserService.getUserId() + "days left: "
//                + currentUserService.getDaysLeft());
//            }
//        }
//        log.info("transaction performed");
//    }
//
//    public static <E> Collection<E> makeCollection(Iterable<E> iter) {
//        Collection<E> list = new ArrayList<E>();
//        for (E item : iter) {
//            list.add(item);
//        }
//        return list;
//    }
}
