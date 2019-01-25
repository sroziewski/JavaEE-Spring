package lab.librari.model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String cover;

    private int price;

    @Transient // we eliminate this field from SQL, because we dont hav it in our DB
    private String view;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)  // many books can have the same publisherId, lazy -- if we call getter for publisher only -- data will be fetched, dynamic proxy to objects
    @JoinColumn(name = "publisher_id")
    private Publisher publisher; // publisher_id -- by default

    // don't use parametrized constructors - required for in-memory mockup only
    public Book(Long id, String title, String author, String cover, int price, Publisher servedIn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.price = price;
        this.view = "";
        this.publisher = servedIn;
    }

    public Book(Long id, String title, String author, String cover, int price, String view, Publisher servedIn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.price = price;
        this.view = view;
        this.publisher = servedIn;
    }

    public Book(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", price=" + price +
                ", publisher=" + publisher +
                '}';
    }
}
