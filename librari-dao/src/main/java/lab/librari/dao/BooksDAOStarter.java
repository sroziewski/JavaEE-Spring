package lab.librari.dao;

import lab.librari.dao.impl.InMemoryBooksDAO;
import lab.librari.dao.impl.jpa.JPABooksDAO;
import lab.librari.model.Publisher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

//@ComponentScan("lab.librari")
public class BooksDAOStarter {

    public static void main(String[] args) {
        System.out.println("BooksDAOStarter.main");

//        ApplicationContext context = new AnnotationConfigApplicationContext(BooksDAOStarter.class);
//        ApplicationContext context = new AnnotationConfigApplicationContext("lab.librari");

        BooksDAO dao = new JPABooksDAO(); // this time we cont use spring

//        BooksDAO dao = new InMemoryBooksDAO();
//        BooksDAO dao = context.getBean(BooksDAO.class);

        List<Publisher> publishers = dao.getAllPublishers();

        System.out.println("Publishers list:");
        for(Publisher p : publishers){
            System.out.println(p);
        }

    }
}
