package interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author shaozk
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) {
        // 执行完毕，返回前拦截
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) {
        // 在处理过程中，执行拦截
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        // 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
        // 返回false则不执行拦截
        HttpSession session = request.getSession();
        // 获取登录的uri，这个是不进行拦截的
        String url = request.getRequestURI();
        if (session.getAttribute("user") != null) {
            return true;
        }
        // 拦截后进入登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/user/login.jsp").forward(request, response);
        return false;
    }

}
