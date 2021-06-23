/*
 * Date: 2021/6/18
 * Author: <https://www.github.com/shaozk>
 */

package service.impl;

import dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pojo.Book;
import response.ResponseResult;
import service.BookService;
import utils.Constants;
import utils.TextUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


/**
 * @author shaozk
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public int addBook(Book book, MultipartFile file, ModelMap map, HttpServletRequest request) throws IOException {

        // 图片判空
        if(!file.isEmpty()) {
            String newFileName = saveFile(file, request);
            // 保存到数据库
            book.setCover(newFileName);
        } else{
            // 使用默认封面
            book.setCover(Constants.BOOK_COVER);
        }

        // 先检查数据,
        if (TextUtil.isEmpty(book.getName())) {

        }
        // 补全数据


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
    public ResponseResult deleteBook(String bookId) {
        int a = bookDao.deleteAllById(bookId);
        return ResponseResult.SUCCESS("删除成功").setData(a);
    }

    @Override
    public int updateBook(Model model, Book book, MultipartFile file, HttpServletRequest request) throws IOException {
        // 图片判空
        if(!file.isEmpty()) {
            String newFileName = saveFile(file, request);
            // 保存到数据库
            book.setCover(newFileName);
        } else{
            // 使用默认封面
            book.setCover(Constants.BOOK_COVER);
        }
        return bookDao.update(book);
    }

    @Override
    public List<String> listBookTypes() {
        return bookDao.listType();
    }

    @Override
    public List<Book> listBookByType(String type) {
        return bookDao.listBookByType(type);
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
        file.transferTo(targetFile);
        return newFileName;
    }

}
