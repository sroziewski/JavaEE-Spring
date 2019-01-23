package lab.librari.web.controller;

import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.logging.Logger;

@Controller
@Adviced
public class PublisherController {

    private Logger logger = Logger.getLogger(PublisherController.class.getName());

    @Autowired
    private BrowsingService bs;

    @RequestMapping(value = "/publishers", method = RequestMethod.GET)
    public String getPublishers(Model model){ // method name doesnt have any meaning
        logger.info("PublisherController:getPublishers by mapping value = \"/publishers\", method = RequestMethod.GET");
        List<Publisher> publishers = bs.getPublishers();
        model.addAttribute("publishers", publishers);

        return "publishers";
    }


}
