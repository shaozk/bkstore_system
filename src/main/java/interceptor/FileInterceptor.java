package interceptor;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author shaozk
 */
public class FileInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {

        System.out.println("进入了文件上传拦截器..");
        /*
            判断是否为文件上传请求，发一个multipart请求（form表单类型为multipart/form-data），
            就表明在控制器实例中存在一个实现MultipartHttpServletRequest接口的request对象
         */
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Map<String, MultipartFile> files = multipartRequest.getFileMap();
            // 获取文件名
            String fileName = multipartRequest.getFile("diff_cover").getOriginalFilename();
            if (!checkFile(fileName)) {
                System.out.println("不合法的文件格式！" + fileName.substring(fileName.lastIndexOf(".") + 1));
                // 跳转到添加书籍界面
                request.getRequestDispatcher("toAddBook").forward(request, response);
                return false;
            }
        }
        return true;
    }

    private boolean checkFile(String fileName) {
        //设置允许上传文件类型
        String suffixList = "jpg,gif,png,ico,bmp,jpeg";

        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (suffixList.contains(suffix.toLowerCase())) {
            System.out.println("参数合法,放行！！！" + suffix);
            return true;
        }

        return false;

    }


    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) {
     // 执行完毕，返回前拦截
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) {
        // 在处理过程中，执行拦截
    }




}
