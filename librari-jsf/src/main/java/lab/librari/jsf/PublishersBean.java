package lab.librari.jsf;

import lab.librari.model.Book;
import lab.librari.model.Publisher;
import lab.librari.service.api.BrowsingService;
import lab.librari.service.impl.BrowsingServiceImpl;

import java.util.List;

//@ManagedBean
public class PublishersBean {

    private BrowsingService bs = new BrowsingServiceImpl();
    private long publisherId;
    private Publisher publisher;

    public long getPublisherId() {
        return publisherId;
    }

    public List<Publisher> getPublishers(){
        return bs.getPublishers();
    }



//    public List<Book> getBooks(String publisherId){
//        long id;
//        try {
//            id = Long.parseLong(publisherId);
//        }
//        catch (NumberFormatException e){
//            id = -1;
//        }
//        return bs.getBooksForPublisher(id);
//    }

    public void setPublisherId(long publisherId){
        this.publisherId = publisherId;
    }

    public Publisher getPublisher() {
        return bs.getPublisher(publisherId);
    }

    public List<Book> getBooks(){
        return bs.getBooksForPublisher(publisherId);
    }

}
