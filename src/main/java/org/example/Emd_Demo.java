package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Emd_Demo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();

        // Setting student class value
        Student student = new Student();
        student.setId(111);
        student.setName("Pratik");
        student.setCity("Ahmedabad");

        // Setting course class value
        Course course = new Course();
        course.setcName("Java");
        course.setDuration("3 months");
        // Giving course object value to Student
        student.setCourse(course);

        // Setting other student class value
        Student student2 = new Student();
        student2.setId(222);
        student2.setName("Brijesh");
        student2.setCity("Morbi");

        // Setting other student's course class value
        Course course1 = new Course();
        course1.setcName("C++");
        course1.setDuration("1.5 months");
        // Giving course object value to Student
        student2.setCourse(course1);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        session.save(student2);
        tx.commit();
        session.close();

    }
}
