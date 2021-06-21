/*
 * Date: 2021/6/18
 * Author: <https://www.github.com/shaozk>
 */

package controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.Book;
import response.ResponseResult;
import service.BookService;
import service.TestService;

import javax.jws.WebParam;
import java.util.List;

/**
 * @author shaozk
 */
@Controller
@RequestMapping("/admin")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/addBook")
    public ModelAndView addBook(Book book) {
        System.out.println(book.toString());
        ModelAndView modelAndView = new ModelAndView();
        ResponseResult responseResult = bookService.addBook(book);
        modelAndView.addObject("responseResult", responseResult);
        modelAndView.setViewName("admin/addBook");
        return modelAndView;
    }


    @RequestMapping("/getBook")
    public ModelAndView getBook(String bookId) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseResult responseResult = bookService.getBook(bookId);
        modelAndView.addObject("responseResult", responseResult);
        modelAndView.setViewName("admin/getBook");
        return modelAndView;
    }

    @RequestMapping("/listBooks")
    public ModelAndView listBooks() {
        ModelAndView modelAndView = new ModelAndView();
        ResponseResult responseResult = bookService.listBooks();
        modelAndView.addObject("responseResult", responseResult);
        modelAndView.setViewName("admin/listBooks");
        return modelAndView;
    }

    @RequestMapping("/deleteBook")
    public ModelAndView deleteBook(String id) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseResult responseResult = bookService.deleteBook(id);
        modelAndView.addObject("responseeResult",responseResult);
        modelAndView.setViewName("admin/deleteBook");
        return modelAndView;
    }

}
