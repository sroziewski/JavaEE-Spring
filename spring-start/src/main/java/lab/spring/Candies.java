package lab.spring;

public class Candies implements Element {

    private String description;

    public Candies() {
        System.out.println("Candies has been constructed");
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
