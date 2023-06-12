package pres;

import business.IBusiness;
import dao.IDao;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres22 {

    public static void main(String[] args) throws Exception {

        /*
        * This class is used to implement dependency injection by dynamic instantiation
        * in order to turn over web service or database with interface through the keyboard.
        * */

        //"DaoImpl dao = new DaoImpl();" with dynamic instantiation
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, give the class of Dao layer :");
        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.getConstructor().newInstance();
        //System.out.println(dao.getData());

        //"BusinessImpl business = new BusinessImpl();" with dynamic instantiation
        System.out.print("Please, give the class of Business layer :");
        String businessClassName = scanner.nextLine();
        Class cBusiness = Class.forName(businessClassName);
        IBusiness business = (IBusiness) cBusiness.getConstructor().newInstance();

        //business.setDao(dao); //Dependency injection
        Method setDao = cBusiness.getDeclaredMethod("setDao", IDao.class);
        setDao.invoke(business,dao); //To execute this method with dependency injection by dynamic instantiation.

        System.out.println("RES = "+business.calculate());
    }
}
