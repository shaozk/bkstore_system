package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pojo.Book;

import java.util.List;

@Mapper
@Repository
public interface BookDao {
    int save(Book book);
    Book findOneById(String bookId);
    List<Book> findAll();
    int deleteAllById(String bookId);

}