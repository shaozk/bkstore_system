/*
 * Date: 2021/6/18
 * Author: <https://www.github.com/shaozk>
 */

package service.impl;

import dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pojo.Book;
import service.BookService;
import utils.Constants;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author shaozk
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public int addBook(Book book, MultipartFile file, Model model, HttpServletRequest request) throws IOException {

        // 图片判空
        if(!file.isEmpty()) {
            String newFileName = saveFile(file, request);
            // 保存到数据库
            book.setCover(newFileName);
        } else{
            // 使用默认封面
            book.setCover(Constants.BOOK_COVER);
        }

        // 保存数据
        return bookDao.save(book);

    }

    @Override
    public Book getBook(String bookId) {
        return bookDao.findOneById(bookId);
    }

    @Override
    public List<Book> listBooks() {
        return bookDao.findAll();
    }


    @Override
    public int deleteBook(String bookId) {
        return bookDao.deleteAllById(bookId);
    }

    @Override
    public String updateBook(Model model, Book book, MultipartFile file, HttpServletRequest request) throws IOException {
        // 图片判空
        if(!file.isEmpty()) {
            String newFileName = saveFile(file, request);
            // 保存到数据库
            book.setCover(newFileName);
        } else {
            Book bookCover = bookDao.findOneById(book.getId());
            book.setCover(bookCover.getCover());
        }
//        更新
        bookDao.update(book);
        return "redirect:/portal/book/listBooks";
    }

    @Override
    public List<String> listBookTypes() {
        return bookDao.listType();
    }

    @Override
    public String listBookByType(String type, Model model) {
        List<Book> bookList = bookDao.listBookByType(type);
        if(bookList.isEmpty()) {
            model.addAttribute("error", "无相关信息");
        } else {
            model.addAttribute("bookList", bookList);
        }
        return "/portal/book/listBooks";
    }



    /**
     * 保存文件
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    private String saveFile(@RequestParam("diff_cover") MultipartFile file, HttpServletRequest request) throws IOException {
        // 保存图片
        String path = request.getSession().getServletContext().getRealPath("/upload/images");

        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }

        // 生成文件新的名字
        String newFileName = UUID.randomUUID() + ".png";

        // 封装上传文件位置的全路径
        File targetFile = new File(realPath, newFileName);
        // 把内存图片写入磁盘中
        file.transferTo(targetFile);

        return newFileName;
    }

}
