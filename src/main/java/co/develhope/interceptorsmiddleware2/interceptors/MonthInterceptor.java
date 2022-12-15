package co.develhope.interceptorsmiddleware2.interceptors;

import co.develhope.interceptorsmiddleware2.entities.Month;
import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Data
@Component
public class MonthInterceptor implements HandlerInterceptor {
    private Month gennaio = new Month(1,"January", "Gennaio", "ggg");
    private Month febbraio = new Month(2,"Febrary", "Febbraio", "fff");
    private Month marzo = new Month(3,"March", "Marzo", "mmm");
    private Month aprile = new Month(4,"April", "Aprile", "aaa");
    private Month maggio = new Month(5,"May", "Maggio", "mmm2");
    private Month giugno = new Month(6,"June", "Giugno", "ggg2");

    private List<Month> months = new ArrayList(Arrays.asList(gennaio,febbraio,marzo,aprile,maggio,giugno));

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Character ch = request.getRequestURI().charAt(request.getRequestURI().length()-1);
        if(!Character.isDigit(ch)){
            response.setStatus(400);
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}