package com.theoSardin.theoSardinExercise.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    DataProvidingService dataProvidingService;

    @Override
    public void doSomethingThatCallsDataProvidingService() {
       try{
           dataProvidingService.getData();
        }
       catch (HttpClientErrorException e){
           if(e.getRawStatusCode()==404){
               doSomethingOn404();
           }
       }
    }

    @Override
    public void doSomethingOn404(){
        System.out.println("Doing stuff");
    }
}
