package lab.librari.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.logging.Logger;

//@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(CounterServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("counter servlet, doGet");
        int count = 0;
        HttpSession httpSession = req.getSession(true);
        if(httpSession.getAttribute("count")!=null){
            count = (int)httpSession.getAttribute("count");
        }
        httpSession.setAttribute("count", ++count);

        Cookie[] cookies = req.getCookies();
        boolean cookieExists = false;
        for (Cookie cookie: cookies) {
            logger.info(cookie.getName()+":"+cookie.getValue());
            if(cookie.getName().equals("custom-cookie")){
                cookieExists = true;
            }

        }

        if(!cookieExists){
            Cookie cookie = new Cookie("custom-cookie", "ABCD");
            cookie.setMaxAge(60*5);
            resp.addCookie(cookie);
        }




//        resp.getWriter().write(
//                "<html><body>CounterServlet: visited "+count+" times</body></html>"
//        );
        req.getRequestDispatcher("/WEB-INF/jsp/counter.jsp").forward(req,resp);
    }
}
