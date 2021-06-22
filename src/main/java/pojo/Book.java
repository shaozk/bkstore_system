package pojo;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Book {
    private int id;
    private String name;
    private float price;
    private String author;
    private String type;
    private String isbn;
    private String publisher;
    private String intro;
    private String cover;
}