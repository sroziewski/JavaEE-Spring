package lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("meal")
@Primary
@PropertySource({"lab.properties"})
public class Meal implements Element {

//    @Autowired
    @Value("${meal.name}") // same as Environment
//    @Value("#{candies.description}") // here we refer to bean's value, and we use # character instead of $, we can refer to any beans an their variables
    private String description = "undefined Meal";

//    @Autowired
//    private Environment env;

    @Override
    public String getDescription() {
//        return env.getProperty("meal.name");
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
