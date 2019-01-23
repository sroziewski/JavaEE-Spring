package lab.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("candies")
@SweetQualifier
public class Candies implements Element {

//    @Resource(name = "candiesList")
    @Resource
//    @Autowired // all implementations of this type and make it as List, but check is there is any Autowire on String field... -> NoUniqueBeanDefinitionException: expected single matching bean but found 2: java.lang.String#0,java.lang.String#1
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
