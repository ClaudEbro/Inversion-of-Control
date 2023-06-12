package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao") //or @Component("dao")//With this annotation we invite spring to create an object of this class on loading like this " <bean id="dao" class="dao.DaoImpl"></bean>".
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("Database version"); //We suppose that we try to connect a database to get weather data.
        double data = 25;
        return data;
    }
}
