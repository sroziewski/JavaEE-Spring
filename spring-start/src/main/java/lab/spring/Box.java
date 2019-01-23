package lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Box {

    @Autowired
//    @Qualifier("candies")
//    @Qualifier("sweets") // same results
    @SweetQualifier // our own q., same results
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
