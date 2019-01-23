package lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("meal")
@Primary
public class Meal implements Element {

    @Autowired
    private String description = "undefined Meal";

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
