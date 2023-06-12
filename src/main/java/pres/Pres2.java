package pres;

import business.BusinessImpl;
import business.IBusiness;
import dao.DaoImpl;
import dao.IDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {

    public static void main(String[] args) throws Exception {

        /*
        * This class is used to implement dependency injection by dynamic instantiation.
        * */

        //"DaoImpl dao = new DaoImpl();" with dynamic instantiation
        Scanner scanner = new Scanner(new File("config.txt"));
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getConstructor().newInstance(); //Overcasting
        //System.out.println(dao.getData());

        //"BusinessImpl business = new BusinessImpl();" with dynamic instantiation
        String businessClassName = scanner.nextLine();
        Class cBusiness = Class.forName(businessClassName);
        IBusiness business = (IBusiness) cBusiness.getConstructor(IDao.class).newInstance(dao);


       /*Without injection by constructor
        IBusiness business = (IBusiness) cBusiness.getConstructor().newInstance();

        //business.setDao(dao); //Static Dependency injection
        Method setDao = cBusiness.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(business,dao); //To execute this method with dependency injection by dynamic instantiation.*/

        System.out.println("RES = "+business.calculate());
    }
}
