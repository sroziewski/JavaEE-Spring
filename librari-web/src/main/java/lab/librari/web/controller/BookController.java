package lab.librari.web.controller;

import lab.librari.model.Book;
import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/books") // we define mapping, further only method
@Adviced
@SessionAttributes("publisher")
public class BookController {
    private Logger logger = Logger.getLogger(PublisherController.class.getName());

    @Autowired
    private BrowsingService bs;
    @Autowired
    private BookValidator validator;

    @InitBinder("bookForm")
    void initBinding(WebDataBinder binder){ // name of this method is random
        binder.setValidator(validator);
    }

//    @RequestMapping(value = "/books", method = RequestMethod.GET)
//    @GetMapping("/books")
    @GetMapping
    public String getBooks(@RequestParam("publisherId") long publisherId, Model model){ // method name doesnt have any meaning
        logger.info("BookController:getBooks by mapping value = \"/books\", method = RequestMethod.GET");
        List<Book> books = bs.getBooksForPublisher(publisherId);
        model.addAttribute("books", books);
        model.addAttribute("publisherId", publisherId);
        return "books";
    }

    @GetMapping("/add")
    public String addBookPrepare(@RequestParam(value = "publisherId", required = true) long publisherId, Model model){
        logger.info("BookController:addBookPrepare for publisherId="+publisherId);
        model.addAttribute("bookForm", new Book());
        model.addAttribute("publisher", bs.getPublisher(publisherId));
        return "addBook";
    }

    @PostMapping("/add") // dont use getBooks method manually! F5 can will add more... in URL retains add method!
    public String addBook(
            @ModelAttribute("bookForm") @Validated Book book,
            BindingResult br,
            @SessionAttribute("publisher") Publisher publisher
    ){
        logger.info("BookController:addBook, book: "+book+", publisher: "+publisher);

        if(br.hasErrors()){
            return "addBook";
        }
        bs.addBook(publisher, book);
        return "redirect:/books?publisherId="+ publisher.getId();
    }

//    <form:errors path="title"/> -- only for title
//    <form:errors path="*"/> -- all error messages are viewed near this place

}
