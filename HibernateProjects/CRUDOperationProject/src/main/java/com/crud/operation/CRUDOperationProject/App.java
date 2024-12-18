package com.crud.operation.CRUDOperationProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.crud.beans.CrudPojoClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        System.out.println("Factory: object" + factory);
        
        CrudPojoClass object = new CrudPojoClass();
        object.setMeassageId(1);
        object.setMessage("Doing CURD Opereation");
        Session session = factory.openSession();
        Transaction transaction= session.beginTransaction();
        //Create
        //session.save(object);
        //Read
//        CrudPojoClass gettingData = (CrudPojoClass) session.get(CrudPojoClass.class, 1);
//        System.out.println("Message For 1: " +gettingData.getMessage());
        
        //Update
        CrudPojoClass updatingData = (CrudPojoClass) session.get(CrudPojoClass.class, 1);
        updatingData.setMessage("My Name is Amit Kumar Pandey");
        session.save(updatingData);
        
        //Delete
//        CrudPojoClass deletingData = (CrudPojoClass) session.get(CrudPojoClass.class, 1);
//        System.out.println("Message For 2: " +deletingData);
//        session.delete(deletingData);
        
        
        transaction.commit();
        session.close();
        factory.close();
        System.out.println("Session: object " + session.isConnected());
        System.out.println("Factory: object " + factory.isClosed());
    }
}
