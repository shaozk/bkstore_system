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
    /**
     * 增添书籍
     * @param book
     * @return
     */
    int save(Book book);

    /**
     * 查找书籍
     * @param bookId
     * @return
     */
    Book findOneById(String bookId);

    /**
     * 查找所有
     * @return
     */
    List<Book> findAll();

    /**
     * 删除
     * @param bookId
     * @return
     */
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

    /**
     * 更新
     * @param book
     * @return
     */
    int update(Book book);
}