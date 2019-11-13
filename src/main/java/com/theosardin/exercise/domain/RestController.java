package com.theosardin.exercise.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    MyService myService;

    @RequestMapping(path = "/doSomething")
    public void callDoSomething(){
        myService.doSomethingThatCallsDataProvidingService();
    }
}
