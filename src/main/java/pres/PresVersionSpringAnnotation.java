package pres;

import business.IBusiness;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresVersionSpringAnnotation {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("dao", "business");
        IBusiness business = context.getBean(IBusiness.class);
        System.out.println("RES = "+business.calculate());
    }
}
