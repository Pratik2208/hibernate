package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQL_Paging {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery("from Student ");
        query.setFirstResult(1);  // It will point to first row of table
        query.setMaxResults(4);   // After fetching first result how many row we want to fetch
        List<Student> list =query.list();  // query will return a list
        for(Student student : list){
            System.out.println(student.getId() + " " + student.getName());
        }
        session.close();
        factory.close();

    }
}
