package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();

        // Fetching student bases on ID number saved in MYSQL D.B.
        Student student = (Student) session.get(Student.class,2);
        Address address = (Address) session.get(Address.class,2);
        System.out.println(student);
        System.out.println(address);
        session.close();
        factory.close();
    }
}
