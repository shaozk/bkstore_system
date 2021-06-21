/*
 * Date: 2021/6/11
 * Author: <https://www.github.com/shaozk>
 */

package pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author shaozk
 */
@Setter
@Getter
@ToString
public class User {
    private String id;
    private String uname;
    private String password;
    private String avatar;
    private String roles;
    private String email;
    private String state;
    private Date createTime;
    private Date updateTime;
}
