package by.training.nc.sd2.controller;

import by.training.nc.sd2.service.ScheduledTransactionsService;
import by.training.nc.sd2.service.impl.ScheduledTransactionsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class ScheduledTransactionsController{
    private static final Logger log = LoggerFactory.getLogger(ScheduledTransactionsServiceImpl.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private ScheduledTransactionsService scheduledTransactionsService;

    @Autowired
    public ScheduledTransactionsController(ScheduledTransactionsService scheduledTransactionsService) {
        this.scheduledTransactionsService = scheduledTransactionsService;
    }



}
