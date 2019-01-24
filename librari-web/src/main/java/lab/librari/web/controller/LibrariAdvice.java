package lab.librari.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(annotations = Adviced.class)
public class LibrariAdvice {

    @ModelAttribute
    public void registerSlogan(Model model){
        model.addAttribute("slogan", "PublisherController Slogan");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleException(
            Model model,
            IllegalArgumentException e,
            HttpServletResponse resp
    ){
        model.addAttribute("errorMessage", e.getMessage());
        resp.setStatus(400);
        return "error";
    }
}
