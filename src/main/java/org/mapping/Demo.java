package org.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Demo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("file:src/main/java/hibernate.cfg.xml").buildSessionFactory();

        // Creating Question Object
        Question question = new Question();
        question.setQuestionId(343);
        question.setQuestionName("What is Java");

        // Creating Answer of First Question
        Answer answer = new Answer();
        answer.setAnswerId(434);
        answer.setAnswerName("Java is Programming Language");

        question.setAnswer(answer);


        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(question);
        session.save(answer);
        transaction.commit();
        session.close();
        factory.close();
    }
}
