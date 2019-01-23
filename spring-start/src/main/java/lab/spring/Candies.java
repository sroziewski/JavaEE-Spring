package lab.spring;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Candies implements Element {

    private List<String> descriptions;

    public Candies() {
        System.out.println("Candies has been constructed");
    }

    @Override
    public String getDescription() {
        return descriptions.stream().reduce((x,y)->x+", "+y).get();
    }

    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }
}
