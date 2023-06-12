package pres;

import business.BusinessImpl;
import dao.DaoImpl;

public class Pres1 {

    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl(); //Static instantiation
        BusinessImpl business = new BusinessImpl(dao); // Injection via constructor
        //business.setDao(dao); //Dependency injection // You remove this when you use injection by constructor.
        System.out.println("RES = "+business.calculate());
    }
}
