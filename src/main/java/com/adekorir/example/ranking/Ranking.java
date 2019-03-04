package com.adekorir.example.ranking;

public class Ranking {

    private Person subject;
    private Person observer;
    private Skill skill;
    private int ranking;

    public void setSubject(Person subject) {
        this.subject = subject;
    }

    public void setObserver(Person observer) {
        this.observer = observer;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
