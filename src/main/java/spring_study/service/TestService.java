package spring_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_study.dao.TestDao;

/**
 * Created by wangyang on 2019/3/10.
 */
@Service("testService")
public class TestService {

    public TestService() {
        System.out.println("TestService create....");
    }


    @Autowired
    TestDao testDao;

    public void printTestDao() {
        System.out.println(testDao);
    }

}
