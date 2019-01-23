package lab.librari.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Adviced.class)
public class LibrariAdvice {

    @ModelAttribute
    public void registerSlogan(Model model){
        model.addAttribute("slogan", "PublisherController Slogan");
    }
}
