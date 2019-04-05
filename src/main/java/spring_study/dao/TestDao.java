package spring_study.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by wangyang on 2019/3/10.
 */
@Repository
public class TestDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
