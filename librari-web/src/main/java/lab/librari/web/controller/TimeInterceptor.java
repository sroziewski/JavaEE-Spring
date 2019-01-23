package lab.librari.web.controller;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

public class TimeInterceptor extends HandlerInterceptorAdapter {

    int opening;
    int closing;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int hour = LocalDateTime.now().getHour();
        if(hour>=opening&&hour<closing){
            return true;
        }
        response.sendRedirect("https://thumbs.gfycat.com/AdmiredConsciousBarracuda-size_restricted.gif");
        return false;
    }

    public void setOpening(int opening) {
        this.opening = opening;
    }

    public void setClosing(int closing) {
        this.closing = closing;
    }
}
