package controller;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @author shaozk
 * 统一异常处理
 */
public class BaseController {
    /**
     *  基于@ExceptionHandler异常处理
     */
    @ExceptionHandler
    public String exception(HttpServletRequest request, Exception ex) {
        request.setAttribute("ex", ex);
        if(ex instanceof SQLException) {
            return "error/sql-error";
        } else if (ex instanceof DataAccessException){
            return "error/data-access-error";
        }
        return "error/error";
    }
}
