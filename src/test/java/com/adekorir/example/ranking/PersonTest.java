package com.adekorir.example.ranking;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    static SessionFactory factory;

    @BeforeClass
    public static void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    @Test
    public void testSavePerson() {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Person person = new Person();
            person.setName("J. C. Smell");

            session.save(person);

            tx.commit();
        }
    }

    @Test
    public void testPersonCreation() {
        Person subject = new Person();
        subject.setName("Adam");

        Person observer = new Person();
        observer.setName("Eve");

        Skill skill = new Skill();
        skill.setName("Java");

        Ranking ranking = new Ranking();
        ranking.setSubject(subject);
        ranking.setObserver(observer);
        ranking.setSkill(skill);
        ranking.setRanking(8);

        String toString = String.format("Subject: %s, Observer: %s, Skill: %s, Ranking: %d",
                ranking.getSubject().getName(),
                ranking.getObserver().getName(),
                ranking.getSkill().getName(),
                ranking.getRanking());

        assertEquals(toString, ranking.toString());
    }
}
