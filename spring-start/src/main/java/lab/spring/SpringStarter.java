package lab.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStarter {

    public static void main(String[] args){
        System.out.println("SpringStarter.main");

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");



//        Box box = new Box();
//        box.setElement(new Candies());

//        Box box = (Box) context.getBean("box");
        Box box = context.getBean(Box.class);
        System.out.println("["+box.describeContent()+"]");
        Box box2 = context.getBean(Box.class);
        System.out.println("["+box2.describeContent()+"]");
        Element candies = context.getBean(Element.class);
        System.out.println("["+candies.getDescription()+"]");

    }
}
