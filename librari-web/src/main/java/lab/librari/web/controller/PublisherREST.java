package lab.librari.web.controller;

import lab.librari.model.Book;
import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class PublisherREST {

    @Autowired
    private BrowsingService bs;

    @GetMapping("/publishers") // feeding data, not presenting...
    public List<Publisher> getPublishersData(){ // framework will serialize data, since we use ResponseBody
        return bs.getPublishers();
    }

    @GetMapping("/publishers/{id}/books") List<Book> getBooks(@PathVariable("id") long publisherId){
        return bs.getBooksForPublisher(publisherId);
    }

    @GetMapping("/publishers/{id}") Publisher getPublisher(@PathVariable("id") long publisherId){
        return bs.getPublisher(publisherId);
    }

    /*@PostMapping("/publishers/{id}/books")// adding a new book
    public Book addBook(
            @PathVariable("id") long publisherId,
            @RequestBody Book book){
        return bs.addBook(bs.getPublisher(publisherId), book);
    }
    */

    @PostMapping("/publishers/{id}/books")// adding a new book
    public ResponseEntity<Book> addBook(
            @PathVariable("id") long publisherId,
            @RequestBody Book book){
        book = bs.addBook(bs.getPublisher(publisherId), book);
//        return new ResponseEntity<>(book, HttpStatus.CREATED); // same as below
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

/*    if we add dependency
            <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-xml</artifactId>
            <version>2.9.7</version>
        </dependency>
    we can serve as XML or Json depending on headers, Accept: (application/json, application/xml)*/

/*
 200 Ok
 201 created POST
 204 No Content -- after deletion
 400 bad request -- bad format
 401 Unauthorized -- not logged
 403 Forbidden no entry
 404 Not Found -- no url
 405 cant be formatted
 406 no method to call
 409 conflict -- existing resource, cant be added with same ID
*/

//    http://localhost:8081/librari-web/rest/publishers/2/books -- in postman programme you can ask for methods allowed to be called, by sending this request as OPTIONS
}
