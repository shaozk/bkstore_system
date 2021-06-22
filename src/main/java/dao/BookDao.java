package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Book;

import java.util.List;

/**
 * @author shaozk
 */
@Mapper
@Repository
public interface BookDao {
    int save(Book book);
    Book findOneById(String bookId);
    List<Book> findAll();
    int deleteAllById(String bookId);

    /**
     * 查询所有书籍类型
     * @return
     */
    List<String> listType();

    /**
     * 通过类型找书籍
     * @return
     * @param type
     */
    List<Book> listBookByType(String type);
}