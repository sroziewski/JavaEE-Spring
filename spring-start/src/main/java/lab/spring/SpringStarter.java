package lab.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringStarter {

    public static void main(String[] args){
        System.out.println("SpringStarter.main");

//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class); // now we dont need appContext file at all



//        Box box = new Box();
//        box.setElement(new Candies());

//        Box box = (Box) context.getBean("box");
        Box box = context.getBean(Box.class);
        System.out.println("[Box: "+box.describeContent()+"]");
        Box box2 = context.getBean(Box.class);
        System.out.println("[Box2: "+box2.describeContent()+"]");
//        Element candies = (Element) context.getBean("element");
        Candies candies = context.getBean(Candies.class);
        System.out.println("["+candies.getClass().getName()+": "+candies.getDescription()+"]");

    }
}
