package com.adekorir.example.ranking;

import org.junit.Test;

public class PersonTest {

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

        // Just to give a visual verification
        System.out.printf("Subject: %s, Observer: %s, Skill: %s, Ranking: %d%n",
                ranking.getSubject().getName(),
                ranking.getObserver().getName(),
                ranking.getSkill().getName(),
                ranking.getRanking());
    }
}
