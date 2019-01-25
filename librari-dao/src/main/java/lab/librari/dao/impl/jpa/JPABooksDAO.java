package lab.librari.dao.impl.jpa;

import lab.librari.dao.BooksDAO;
import lab.librari.model.Book;
import lab.librari.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class JPABooksDAO implements BooksDAO {

    private EntityManager em = Persistence
            .createEntityManagerFactory("librariUnit")
            .createEntityManager();

    @Override
    public List<Publisher> getAllPublishers() {
        return em.createQuery("select p from Publisher p").getResultList(); // JPQL -> HQL -> HQL
    }

    @Override
    public List<Publisher> getPublishersPage(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return null;
    }

    @Override
    public List<Book> getBooksByPublisher(Publisher r) {
        return null;
    }

    @Override
    public Book getBookById(Long mId) {
        return null;
    }

    @Override
    public Publisher addPublisher(Publisher r) {
        return null;
    }

    @Override
    public Book addBook(Book m) {
        return null;
    }
}
