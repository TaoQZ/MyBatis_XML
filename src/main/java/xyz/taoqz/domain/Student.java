package xyz.taoqz.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Student {
    private Integer sid;

    private String sname;

    private String sex;

    private Integer gid;

    private String remark;

    private Grade grade;

    private List<Teacher> teachers = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sid, student.sid) &&
                Objects.equals(sname, student.sname) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(gid, student.gid) &&
                Objects.equals(remark, student.remark) &&
                Objects.equals(grade, student.grade) &&
                Objects.equals(teachers, student.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, sname, sex, gid, remark, grade, teachers);
    }
}
