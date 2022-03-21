package controller.portal;

import controller.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pojo.Book;
import service.BookService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.util.List;

/**
 * @author shaozk
 */
@Controller
@RequestMapping("portal/book")
public class BookPortalController extends BaseController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/search")
    public String search(@Param("type") String type, Model model) {
        return bookService.listBookByType(type, model);
    }

    @RequestMapping("/listBooks")
    public String listBooks(Model model) {
        List<Book> bookList = bookService.listBooks();
        model.addAttribute("bookList", bookList);

        return "/portal/book/listBooks";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "portal/book/addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(@Valid @ModelAttribute Book book, BindingResult bindingResult, @RequestParam("diff_cover") MultipartFile file, Model model, HttpServletRequest request) throws IOException {

        // 数据验证
        if (bindingResult.hasErrors()){
            handleError(bindingResult, model);
            /*返回注册页面*/
            return "/portal/book/addBook";
        }
        else {
            // 添加书籍
            bookService.addBook(book, file, model, request);
            return "redirect:/portal/book/listBooks";
        }

    }

    @RequestMapping("/showCover/{cover}")
    public void showCover(@PathVariable("cover") String cover, HttpServletRequest request, HttpServletResponse response) {

        String path = request.getSession().getServletContext().getRealPath("/upload/images");

        // 加上图片后缀名 (.png)
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
        return "portal/book/updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Model model, Book book, @RequestParam("diff_cover") MultipartFile file, HttpServletRequest request ) throws IOException {
        return bookService.updateBook(model, book, file, request);
    }

    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") String id) {
        bookService.deleteBook(id);
        return "redirect:/portal/book/listBooks";
    }

    private void handleError(BindingResult bindingResult, Model model) {
        FieldError name = bindingResult.getFieldError("name");
        FieldError author = bindingResult.getFieldError("author");
        FieldError price = bindingResult.getFieldError("price");
        FieldError type = bindingResult.getFieldError("type");
        FieldError isbn = bindingResult.getFieldError("isbn");
        FieldError publisher = bindingResult.getFieldError("publisher");
        FieldError intro = bindingResult.getFieldError("intro");

        //哪个验证失败，就回显示哪个
        if(name!=null){
            String nameMsg = name.getDefaultMessage();
            model.addAttribute("nameMsg",nameMsg);
        }
        if(author!=null){
            String authorMsg = author.getDefaultMessage();
            model.addAttribute("authorMsg",authorMsg);
        }
        if(price!=null){
            String priceMsg = price.getDefaultMessage();
            model.addAttribute("priceMsg",priceMsg);
        }
        if(type!=null){
            String typeMsg = type.getDefaultMessage();
            model.addAttribute("typeMsg",typeMsg);
        }
        if(isbn!=null){
            String isbnMsg = isbn.getDefaultMessage();
            model.addAttribute("isbnMsg",isbnMsg);
        }
        if(publisher!=null){
            String pubMsg = publisher.getDefaultMessage();
            model.addAttribute("pubMsg",pubMsg);
        }
        if(intro!=null){
            String introMsg = intro.getDefaultMessage();
            model.addAttribute("introMsg",introMsg);
        }
    }

}
