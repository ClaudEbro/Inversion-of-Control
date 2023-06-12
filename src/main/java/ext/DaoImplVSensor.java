package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component("sv")
public class DaoImplVSensor implements IDao {

    /*
     * By this class, we try to get weather data with another way such as sensors.
     * */

    @Override
    public double getData() {
        System.out.println("Sensors Version");
        double data = 20;
        return data;
    }
}
