package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Book;
import service.BookService;

import java.util.List;

/**
 * @author shaozk
 */
@Controller
public class IndexController {

    @Autowired
    private BookService bookService;

    @RequestMapping("index")
    public String index(Model model) {
        List<Book> bookList = bookService.listBooks();
        List<String> bookType = bookService.listBookTypes();

        model.addAttribute("bookList", bookList);
        model.addAttribute("bookType", bookType);

        return "admin/adminIndex";
    }
}
