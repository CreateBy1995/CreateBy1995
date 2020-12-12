package main;

import main.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: dongcx
 * @Description:
 * @Date: 2020-12-12
 **/
@Service
public class TestService {
    @Autowired
    private TestDao testDao;
    @Transactional
    public void getWithTransaction(){
        testDao.get(1);
        testDao.get(1);
    }
}
