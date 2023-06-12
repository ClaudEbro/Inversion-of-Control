package business;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service //or @Component
public class BusinessImpl implements IBusiness {

    /*@Autowired //Automatic injection. That means when Spring creates an object of BusinessImpl, it has to inject an object of type dao into IDao. This way is deprecated.That why we use the injection by constructor.
    @Qualifier("sv")// If there are more instances for the same interface, you can specify where to inject.*/
    private IDao dao; //Lose coupling

    public BusinessImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calculate() {
        double d = dao.getData();
        double res = d*12.5; // We call getData method of IDao interface.
        return res;
    }

    /*
    * To allow injection of a value into dao variable such as
    * an object of a class which implements IDao interface.
    * */
    public void setDao(IDao dao) {
        this.dao = dao;
    } // You don't need the setter with injection by constructor with XML.
}
