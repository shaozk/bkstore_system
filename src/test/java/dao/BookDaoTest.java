package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.Book;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void save() {
        Book book = new Book();
        book.setName("图灵机");
        book.setAuthor("turing");
        book.setPrice(66);
        book.setCover("无");
        book.setIntro("有人在等伞，而我在等于停");
        book.setIsbn("913667678");
        book.setPublisher("电子工业");
        int ind = bookDao.save(book);
        assert ind == 1;
    }

    @Test
    public void findOneById() {
        Book book = bookDao.findOneById("1");
        assert book.getId() == 1;
        System.out.println(book.toString());
    }

    @Test
    public void findAll() {
        List<Book> bookList = bookDao.findAll();
        for(Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    public void deleteAllById() {
        int ind = bookDao.deleteAllById("6");
    }
}