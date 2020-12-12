package main.dao;

import main.domain.Test;

import java.util.List;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-11
 **/
public interface TestDao {
    Test get(Integer id);

    void addTest(List<Test> tests);
}
