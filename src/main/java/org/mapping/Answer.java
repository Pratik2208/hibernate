package org.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {
    public Answer(int answerId, String answerName) {
        this.answerId = answerId;
        this.answerName = answerName;
    }

    public Answer() {
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    @Id
    @Column(name = "answer_id")
    private int answerId;
    private String answerName;

}
