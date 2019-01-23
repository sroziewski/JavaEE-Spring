package lab.spring;

public class Box {

    private Element element;

    public Box() {
        System.out.println("Box has been constructed");
    }

    public Box(Element element) {
        this.element = element;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public String describeContent(){
        return "Box Content is: "+element.getDescription();
    }
}
