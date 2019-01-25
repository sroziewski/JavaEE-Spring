package lab.librari.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "PUBLISHER")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // we dont want to manage ids
    private Long id;

    private String name; // by default there are treated as columns

    @Column(name = "LOGOIMAGE")
    private String logoImage; // logo_image

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY) // backing/reflexive relation
    private List<Book> books = new ArrayList<>();


    // don't use parametrized constructors - required for in-memory mockup only
    public Publisher(Long id, String name, String logoImage) {
        this.id = id;
        this.name = name;
        this.logoImage = logoImage;
    }

    public Publisher() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(String logoImage) {
        this.logoImage = logoImage;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoImage='" + logoImage + '\'' +
                '}';
    }
}
