package pojo;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

/**
 * @author shaozk
 */
@Data
@ToString
public class Book {
    private String id;
    @NotBlank(message="{book.name.required}")
    private String name;
    @Min(value = 0, message = "{book.price.zero}")
    private float price;
    @NotBlank(message="{book.author.required}")
    private String author;
    @NotBlank(message="{book.type.required}")
    private String type;
    @Length(min = 13, max=13, message = "{book.isbn.thirteen}")
    @NotBlank(message = "{book.isbn.required}")
    private String isbn;
    @NotBlank(message="{book.publisher.required}")
    private String publisher;
    @NotBlank(message = "{book.intro.required}")
    private String intro;
    private String cover;
}