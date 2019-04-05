package spring_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring_study.dao.TestDao;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * Created by wangyang on 2019/3/10.
 */
@Service("testService")
public class TestService {

    public TestService() {
        System.out.println("TestService create....");
    }


    // 下面两个都是spring的注解
    //@Qualifier("testDao") // 指定组建id
    //@Autowired(required = false)
    //下面是java的注解
    //@Resource(name = "testDao2")
    @Inject
    TestDao testDao;

    public void printTestDao() {
        System.out.println("lable in service: " + testDao.getLable());
    }

}
