package controller.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pojo.Book;
import service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

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

    @RequestMapping("/listBooks")
    public String listBooks(Model model) {
        List<Book> bookList = bookService.listBooks();
        model.addAttribute("bookList", bookList);
        return "portal/listBooks";

    }

    @RequestMapping("/toAddBook")
    public String toAddBook() {
        return "/portal/addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Book book, @RequestParam("diff_cover") MultipartFile file, ModelMap map, HttpServletRequest request) throws IOException {

        bookService.addBook(book, file, map, request);
        return "redirect:/portal/book/listBooks";
    }



    @RequestMapping("/showCover/{cover}")
    public void showCover(@PathVariable("cover") String cover, HttpServletRequest request, HttpServletResponse response) {

        String path = request.getSession().getServletContext().getRealPath("/upload/images");

        File imgFile = new File(path + "/" + cover + ".png");

        try(InputStream is = new FileInputStream(imgFile);
            OutputStream os = response.getOutputStream();){
            // 图片文件流缓存池
            byte [] buffer = new byte[1024];
            while(is.read(buffer) != -1){
                os.write(buffer);
            }
            os.flush();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, Integer id) {
        Book book = bookService.getBook(id + "") ;
//        进行数据回显
        model.addAttribute("book", book);
        return "/portal/updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Book book, @RequestParam("diff_cover") MultipartFile file, HttpServletRequest request ) throws IOException {

        bookService.updateBook(model, book, file, request);
        Book books = bookService.getBook(book.getId() + "");
        model.addAttribute("books", books);

        return "redirect:/portal/book/listBooks";
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") Integer id) {
        bookService.deleteBook(id + "");
        return "redirect:/portal/book/listBooks";
    }


}
