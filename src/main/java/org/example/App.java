package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Project Started ...." );
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();
        System.out.println(factory);

        // Creating Student Object
        Student student = new Student();
        student.setId(2);
        student.setName("Smith");
        student.setCity("Canada");

        // Creating Address Object
        Address address = new Address();
        address.setStreet("Nagar");
        address.setCity("Jamnagar");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.3322);

        // Opening Session
        Session session = factory.openSession();

        // Begin Transaction for this session
        Transaction transaction = session.beginTransaction();

        // Save Student object data into session
        session.save(student);
        session.save(address);
        transaction.commit();
        session.close();

    }
}
