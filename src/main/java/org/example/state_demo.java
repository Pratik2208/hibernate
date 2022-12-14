package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class state_demo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();
        // Creating student object
        Student student = new Student();
        student.setId(1212);
        student.setName("Pratik");
        student.setCity("Ahmedabad");
        student.setCourse(new Course("java","3 months"));
        // Transient :  Now we created object we have not stored at anywhere so, It is in Transient state

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);   //  Persistent : Now session is saving data into database so it is persistent state

        transaction.commit();
        session.close();    // Detached : Means we have stored data and we are closing session

        // student.setName("John"); john will not store into database because last value before closing session is Pratik
        factory.close();
    }
}
