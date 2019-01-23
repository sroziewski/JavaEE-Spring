package lab.librari.web.controller;

import lab.librari.model.Book;
import lab.librari.service.api.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class BookController {
    private Logger logger = Logger.getLogger(PublisherController.class.getName());

    @Autowired
    private BrowsingService bs;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(@RequestParam("publisherId") long publisherId, Model model){ // method name doesnt have any meaning
        logger.info("BookController:getBooks by mapping value = \"/books\", method = RequestMethod.GET");
        List<Book> books = bs.getBooksForPublisher(publisherId);
        model.addAttribute("books", books);

        return "books";
    }
}
