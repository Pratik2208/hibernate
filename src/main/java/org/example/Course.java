package org.example;

import javax.persistence.Embeddable;

@Embeddable
public class Course {
    private String cName;
    private String duration;

    public Course(String cName, String duration) {
        this.cName = cName;
        this.duration = duration;
    }

    public Course() {
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
