/*
 * Date: 2021/6/18
 * Author: <https://www.github.com/shaozk>
 */

package service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import pojo.Book;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    int addBook(Book book, MultipartFile file, Model model, HttpServletRequest request) throws IOException;

    /**
     * 通过id获取书籍
     * @param bookId
     * @return
     */
    Book getBook(String bookId);

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
    int deleteBook(String bookId);

    /**
     * 更新书籍信息
     * @param book
     * @return
     */
    String updateBook(Model model, Book book, MultipartFile file, HttpServletRequest request) throws IOException;

    /**
     * 列出书籍类别
     * @return
     */
    List<String> listBookTypes();

    /**
     * 按照类型找书籍
     * @return
     * @param type
     * @param model
     */
    String listBookByType(String type, Model model);

}
