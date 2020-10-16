package com.tqq.sleuth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author ： tqq
 * @date ： 2020/10/15 18:50
 * @Description:
 */
@Service
public class HelloService {
    private static final org.apache.commons.logging.Log Log = LogFactory.getLog(HelloController.class);
    public String backgroundFun(){
        Log.info("backgroundFun");
        return "backgroundFun";
    }
    @Scheduled(cron = "0/10 * * * * ?")
    public void sche1(){
        Log.info("backgroundFun");
        Log.info("start:");
        backgroundFun();
        Log.info("end:");


    }

}
