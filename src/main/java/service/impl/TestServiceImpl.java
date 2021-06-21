/*
 * Date: 2021/6/11
 * Author: <https://www.github.com/shaozk>
 */

package service.impl;

import dao.BookDao;
import dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import response.ResponseResult;
import service.TestService;

/**
 * @author shaozk
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
   private TestDao testDao;

    @Override
    public ResponseResult test() {
        return testDao.test();
    }
}
