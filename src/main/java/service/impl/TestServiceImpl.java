/*
 * Date: 2021/6/11
 * Author: <https://www.github.com/shaozk>
 */

package service.impl;

import dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.TestService;

/**
 * @author shaozk
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
   private TestDao testDao;

    @Override
    public String test() {
        return testDao.test();
    }
}
