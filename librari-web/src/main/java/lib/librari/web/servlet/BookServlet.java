package lib.librari.web.servlet;

import lab.librari.service.api.BrowsingService;
import lab.librari.service.impl.BrowsingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/books")
public class BookServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(CounterServlet.class.getName());
    private BrowsingService bs = new BrowsingServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long publisherId;
        try {
            publisherId = Long.parseLong(req.getParameter("publisherId"));
        }
        catch (NumberFormatException e){
            publisherId = -1;
        }
        req.setAttribute("books",  bs.getBooksForPublisher(publisherId));
        req.setAttribute("publisher",  bs.getPublisher(publisherId));

//        req.setAttribute("book",  "SLOGAN 234!");
        req.getRequestDispatcher("/WEB-INF/jsp/books.jsp").forward(req,resp);
    }
}
