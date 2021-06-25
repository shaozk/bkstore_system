package convert;

import org.springframework.core.convert.converter.Converter;
import pojo.Book;

/**
 * @author shaozk
 */
public class BookConvert implements Converter<String, Book> {
    @Override
    public Book convert(String source) {
        Book book = new Book();
        // 以逗号分隔
        String[] stringValues = source.split(",");
        book.setName(stringValues[0]);
        book.setAuthor(stringValues[1]);
        book.setPrice(Float.parseFloat(stringValues[2]));
        book.setType(stringValues[3]);
        book.setIsbn(stringValues[4]);
        book.setPublisher(stringValues[5]);
        book.setIntro(stringValues[6]);
        book.setCover(stringValues[7]);
        return book;
    }
}
