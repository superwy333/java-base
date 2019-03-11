package spring_study.service;

import org.springframework.stereotype.Service;

/**
 * Created by wangyang on 2019/3/10.
 */
@Service("testService")
public class TestService {

    public TestService() {
        System.out.println("TestService create....");
    }

}
