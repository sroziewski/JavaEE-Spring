package lab.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("lab.spring")
public class Config {

    @Bean
    public String getMealString(){ // name of this method is random :)
        return "Meal Configuration";
    }
//    @Bean(name = "descriptions")
//    public List<String> getCandiesList(){
//         return Arrays.asList("First Candy",
//        "Second Candy from Bean",
//        "Third Candy from Bean",
//        "Fourth Candy from Bean");
//    }
    @Bean // same results
    public List<String> descriptions(){
        return Arrays.asList("First Candy",
                "Second Candy from Bean",
                "Third Candy from Bean",
                "Fourth Candy from Bean");
    }

}
