package ext;

import dao.IDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("wsv") // or @Component("wsv")
public class DaoImpl2 implements IDao {

    /*
    * By this class, we try to get weather data with another way such as a web service.
    * */

    @Override
    public double getData() {
        System.out.println("Web service version");
        double data = 37;
        return data;
    }
}
