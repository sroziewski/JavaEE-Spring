package lab.librari.web.servlet;

import lab.librari.service.api.BrowsingService;
import lab.librari.service.impl.BrowsingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

//@WebServlet("/publishers")
public class PublisherServlet extends HttpServlet {


    private Logger logger = Logger.getLogger(CounterServlet.class.getName());
    private BrowsingService bs = new BrowsingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("publisher servlet, publishers list");

//        Optional<String> str = bs.getPublishers().stream().map(p -> "<tr><td>" + p.getName() + "</td><td> <img src=\"" + p.getLogoImage() + "\"></td></tr>").reduce((x, y) -> x + y);
//
//        resp.getWriter().write(
//                "<html><body>Publishers list: visited <table><tr><th>Publisher</th><th>Logo</th></tr>"+str.get()+"</table> times</body></html>"
//        );


        req.setAttribute("publishers",  bs.getPublishers());
        req.setAttribute("slogan",  "SLOGAN 234!");
        req.getRequestDispatcher("/WEB-INF/jsp/publishers.jsp").forward(req,resp);
    }
}
