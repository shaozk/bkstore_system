package pojo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;


/**
 * @author shaozk
 */
@Data
@ToString
public class Setting {

    private String id;
    private String key;
    private String value;
    private Date createTime;
    private Date updateTime;
}
