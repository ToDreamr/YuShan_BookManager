package com.book.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/8 22:35
 */
public class FightQueryTask extends Thread implements FightQuery{

    private final String origin;
    private final String destination;
    private final List<String> flightList=new ArrayList<>();

    public FightQueryTask(String origin, String destination,String airline) {
        super("["+airline+"]");
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public List<String> get() {
        return this.flightList;
    }

    @Override
    public void run() {
        System.out.printf("%s-query from %s to %s",getName(),origin,destination);
        int randomVal= ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randomVal);
            this.flightList.add(getName()+"-"+randomVal);
            System.out.printf("The flight:%s list query successful\n",getName());
            System.out.println();
        } catch (Exception e) {

        }
    }
}
