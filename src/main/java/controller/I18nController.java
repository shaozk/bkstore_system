package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * @author shaozk
 */
@Controller
public class I18nController {
    /**
     * locale接收请求参数locale值，并存储到session中
     */
    @RequestMapping("/i18nTest")
    public String first(Locale locale) {
        return "redirect:/portal/book/listBooks";
    }
}
