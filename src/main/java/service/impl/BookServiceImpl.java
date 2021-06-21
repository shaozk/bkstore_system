/*
 * Date: 2021/6/18
 * Author: <https://www.github.com/shaozk>
 */

package service.impl;

import dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Book;
import response.ResponseResult;
import service.BookService;
import utils.TextUtil;

import java.util.List;


/**
 * @author shaozk
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public ResponseResult addBook(Book book) {
        // 先检查数据,
        if (TextUtil.isEmpty(book.getName())) {
            return ResponseResult.FAILED("错误");
        }

        // 补全数据

        // 保存数据
        bookDao.save(book);

        // 返回结果
        return ResponseResult.SUCCESS("添加书籍成功");
    }

    @Override
    public ResponseResult getBook(String bookId) {
        Book book = bookDao.findOneById(bookId);
        return ResponseResult.SUCCESS("查询成功").setData(book);
    }

    @Override
    public ResponseResult listBooks() {
        List<Book> bookList = bookDao.findAll();
        return ResponseResult.SUCCESS("查询成功").setData(bookList);
    }

    @Override
    public ResponseResult deleteBook(String bookId) {
        int a = bookDao.deleteAllById(bookId);
        return ResponseResult.SUCCESS("删除成功").setData(a);
    }

    @Override
    public ResponseResult updateBook(String categoryId, Book book) {
        return null;
    }
}
