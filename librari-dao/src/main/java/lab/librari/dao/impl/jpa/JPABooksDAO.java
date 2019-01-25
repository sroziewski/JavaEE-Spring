package lab.librari.dao.impl.jpa;

import lab.librari.dao.BooksDAO;
import lab.librari.model.Book;
import lab.librari.model.Publisher;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Primary
public class JPABooksDAO implements BooksDAO {

    /*private EntityManager em = Persistence
            .createEntityManagerFactory("librariUnit")
            .createEntityManager();*/

    @PersistenceContext(name = "librariUnit")
    private EntityManager em;

    @Override
    public List<Publisher> getAllPublishers() {
        return em
                .createQuery("select p from Publisher p", Publisher.class)
                .getResultList(); // JPQL -> HQL -> HQL
    }

    @Override
    public List<Publisher> getPublishersPage(int pageNumber, int pageSize) {
//        return null;
        return em.createQuery("select p from Publisher p", Publisher.class)
                .setFirstResult((pageNumber-1) * pageSize)
                .setMaxResults(pageSize).getResultList();
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return em.find(Publisher.class, id); // it can be from DB or Cache!
    }

    @Override
    public List<Book> getBooksByPublisher(Publisher p) {
        return em
                .createQuery("select b from Book b where b.publisher=:par", Book.class)
                .setParameter("par", p)
                .getResultList();
    }

    @Override
    public Book getBookById(Long mId) {
        return em.find(Book.class, mId);
    }

    @Override
    public Publisher addPublisher(Publisher r) {
        return null;
    }

    @Override
//    @Transactional(propagation = Propagation.REQUIRED) // in method call is needed, if not available, opens on the specific level and closes, if exists, will be joined to existing transaction
//    @Transactional(propagation = Propagation.REQUIRES_NEW) // in method call is needed, every time create new one, we will have more transactions when there are more transactions with not committed operations, it will not rollback any committed operations for other open transactions
//    @Transactional(propagation = Propagation.SUPPORTS) // if it is open, I support, but if not I will do autocommit, without transaction
//    @Transactional(propagation = Propagation.MANDATORY) // it is required, if not opened -> exception!, it has to be created in advance
//    @Transactional(propagation = Propagation.NEVER) // only non-transactional operations, it stops any existing transactions -> IllegalTransactionStateException, Existing transaction found for transaction marked with propagation 'never'
// we can propagate transactions... we have here 7 possibilities, for us transaction is not necessary
    // here we dont have transaction in DAO
    public Book addBook(Book b) {
        em.persist(b);
        return b;
    }
}
