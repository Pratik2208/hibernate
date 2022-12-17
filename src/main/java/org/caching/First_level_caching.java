package org.caching;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class First_level_caching {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();
        // First level caching is by default enabled for session and when we close session then it is not working
        // Before session closes , session will hold object into it's cache and if we again want that object than, it will not
        //  continue: fire any query it will give object from cache
        Session session = factory.openSession();
        Student student = session.get(Student.class,1);
        System.out.println(student);

        // we are fetching same object then it will not fire query again because it will give from cache. Look at console
        Student student1 = session.get(Student.class,1);
        System.out.println(student1);

    }



}
