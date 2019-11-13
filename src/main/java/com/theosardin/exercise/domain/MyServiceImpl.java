package com.theosardin.exercise.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class MyServiceImpl implements MyService {

    public final static String THE_DEED_IS_DONE="I did the thing !";

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
    public String doSomethingOn404(){
        return THE_DEED_IS_DONE;
    }
}
