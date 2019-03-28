package spring_test_001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring_test_001.processor.Processor;

@Controller
public class TestController {

    @Autowired
    Processor processor;

    public void userLogin() {
        System.out.println("UserLogin>>>>>>>>>");
        System.out.println(processor.getProjectId());
        processor.userLogin();

    }
}
