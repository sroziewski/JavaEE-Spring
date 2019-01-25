package lab.librari.service.impl;


import lab.librari.dao.BooksDAO;
import lab.librari.dao.impl.InMemoryBooksDAO;
import lab.librari.model.Book;
import lab.librari.model.Page;
import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BrowsingServiceImpl implements BrowsingService {

    Logger logger = Logger.getLogger(BrowsingServiceImpl.class.getName());

    @Autowired
    private BooksDAO bDao = new InMemoryBooksDAO();

    @Autowired
    private PlatformTransactionManager tm;

    public List<Publisher> getPublishers() {
        return bDao.getAllPublishers();
    }

    @Override
    public Page<Publisher> getPublishersPage(int pageNumber, int pageSize) {
        return new Page<>(
                bDao.getPublishersPage(pageNumber, pageSize),
                bDao.getAllPublishers().size(),
                pageNumber,
                pageSize);
    }

    public Publisher getPublisher(Long id) {
        return bDao.getPublisherById(id);
    }


    public List<Book> getBooksForPublisher(Long rId) {
        Publisher r = getPublisher(rId);
        return bDao.getBooksByPublisher(r);
    }

    public Book getBookById(Long mId) {
        return bDao.getBookById(mId);
    }

    public Publisher addPublisher(Publisher p) {
        return bDao.addPublisher(p);
    }

    @Transactional(rollbackFor = Exception.class) // now we make a transaction only by annotation, by runtime
    @PreAuthorize("hasAuthority('ADMIN')") // will pop up an authorization window if not logged in
    public Book addBook(Publisher p, Book b) {

        logger.info("about to add publisher " + p + " and book " + b);

//        TransactionStatus ts = tm.getTransaction(new DefaultTransactionDefinition());

        if(b.getPrice()<=0){
//            tm.rollback(ts);
            throw  new IllegalArgumentException("negative price");
        }

// <tx:annotation-driven/> in daoContext.xml

        p = p.getId() == null ? bDao.addPublisher(p) : bDao.getPublisherById(p.getId());
        b.setPublisher(p);
        b = bDao.addBook(b);

//        tm.commit(ts); // we can handle possible exceptions

        return b;
    }

}
