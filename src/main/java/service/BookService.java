/*
 * Date: 2021/6/18
 * Author: <https://www.github.com/shaozk>
 */

package service;

import pojo.Book;
import response.ResponseResult;

import java.util.List;

/**
 * @author shaozk
 */
public interface BookService {
    /**
     * 添加书籍
     * @param book
     * @return
     */
    ResponseResult addBook(Book book);

    /**
     * 通过id获取书籍
     * @param bookId
     * @return
     */
    ResponseResult getBook(String bookId);

    /**
     * 列出全部书籍
     * @return
     */
    List<Book> listBooks();

    /**
     * 通过id删除书籍
     * @param bookId
     * @return
     */
    ResponseResult deleteBook(String bookId);

    /**
     * 更新书籍信息
     * @param categoryId
     * @param book
     * @return
     */
    ResponseResult updateBook(String categoryId, Book book);

    /**
     * 列出书籍类别
     * @return
     */
    List<String> listBookTypes();

    /**
     * 按照类型找书籍
     * @return
     * @param type
     */
    List<Book> listBookByType(String type);
}
