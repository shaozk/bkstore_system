/*
 * Date: 2021/6/11
 * Author: <https://www.github.com/shaozk>
 */

package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.TestService;

/**
 * @author shaozk
 * 测试
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return testService.test();
    }

    /**
     * 测试ModelAndView
     * @return ModelAndView
     */
    @RequestMapping("/test")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView();
        String str = new String("hello");
        view.addObject("str", str);
        view.setViewName("test");
        return view;
    }

    @RequestMapping(value = "/testHello", method = RequestMethod.POST)
    public ModelAndView testHello() {
        ModelAndView modelAndView = new ModelAndView();
        String responseResult = testService.test();
        modelAndView.addObject("responseResult", responseResult);
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
