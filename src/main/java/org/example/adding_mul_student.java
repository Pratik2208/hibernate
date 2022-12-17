package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class adding_mul_student {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();
        int[] id = {1,2,3,4,5};
        String[] names = {"john","cena","tommy","under","taker"};
        String[] cities = {"USA","USA","USA","USA","USA",};

        // Creating Arraylist for saving multiple student's object
        ArrayList<Student> students = new ArrayList<>();

        // Creating objects for Arraylist and Storing into arraylist
        for (int i = 0; i <5 ; i++) {
            students.add(new Student(id[i],names[i],cities[i] ));
        }

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        for(Student student : students){
            session.save(student);
        }
        transaction.commit();
        session.close();
        //System.out.println(students.get(2));
        factory.close();
    }
}
