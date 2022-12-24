package com.book.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/8 22:54
 */
public class FightQueryExample {

    private static List<String> flightCompany = Arrays.asList("CSA","CEA","HNA");

    public static void main(String[] args) {
        List<String> result=search("SH","BJ");
    }
    private static List<String> search(String original,String dest){
        final List<String> result=new ArrayList<>();
        List<FightQueryTask> tasks=flightCompany.stream()
                .map(f->creatSearchTask(f,original,dest))
                .collect(Collectors.toList());
        tasks.forEach(Thread::start);
        tasks.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException e) {

            }
        });
        tasks.stream().map(FightQuery::get).forEach(result::addAll);
        return result;
    }
    private static FightQueryTask creatSearchTask(String fight,
    String original,String dest){
        return new FightQueryTask(fight,original,dest);
    }
}
