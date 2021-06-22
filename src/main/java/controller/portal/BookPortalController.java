package controller.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

/**
 * @author shaozk
 */
@Controller
@RequestMapping("portal/book")
public class BookPortalController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/search")
    public String search() {
        return "hello";
    }

    @RequestMapping("/getBookDetail")
    public String bookDetail() {
        return "hello";

    }

    @RequestMapping("/list")
    public String listBooks() {
        return "hello";

    }

}
