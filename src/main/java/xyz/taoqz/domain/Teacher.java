package xyz.taoqz.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Teacher {
    private Integer tid;

    private String tname;

    private List<Student> students = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", students=" + students +
                '}';
    }
}
