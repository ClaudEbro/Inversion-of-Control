package pres;

import business.IBusiness;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresVersionSpringXML {

    public static void main(String[] args) {
        ApplicationContext springContext = new ClassPathXmlApplicationContext("config.xml");
        IBusiness business = springContext.getBean(IBusiness.class);

        /* You call also call a bean like that.
        **IBusiness business = (IBusiness) springContext.getBean("business");*/
        System.out.println("RES = "+business.calculate());
    }
}
