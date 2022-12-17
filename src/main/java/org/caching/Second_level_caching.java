package org.caching;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Second_level_caching {
    // Second level caching is enabled at session-factory level
    // means same object is fetched by multiple session even after closing sessions
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Student student1 = session.get(Student.class,1);
        System.out.println(student1);
        session.close();

        // fetching same object after closing session and opening session
        Session session1 = factory.openSession();
        Student student2 = session1.get(Student.class,1);
        System.out.println(student2);
        session1.close();

        factory.close();

    }

}
