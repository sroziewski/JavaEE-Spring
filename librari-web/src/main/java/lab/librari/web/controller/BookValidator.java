package lab.librari.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import lab.librari.model.Book;

@Component
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Book book = (Book) o;

//        if(book.getPrice()<=0){
//            errors.rejectValue("price", "error.book.price.negative");
//        }
//        if(book.getTitle()==null||book.getTitle().trim().isEmpty()){
//            br.rejectValue("title", "error.book.title.empty");
//        } // below is same result
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.book.title.empty");
    }
}
