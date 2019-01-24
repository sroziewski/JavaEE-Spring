package lab.librari.web.controller;

import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
//    if we add dependency
//            <dependency>
//            <groupId>com.fasterxml.jackson.dataformat</groupId>
//            <artifactId>jackson-dataformat-xml</artifactId>
//            <version>2.9.7</version>
//        </dependency>
//    we can serve as XML or Json depending on headers, Accept: (application/json, application/xml)
}
