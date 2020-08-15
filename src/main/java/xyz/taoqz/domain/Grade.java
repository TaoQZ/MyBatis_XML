package xyz.taoqz.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "grade")
public class Grade implements Serializable {
    @Id
    @Column(name = "gid")
    @GeneratedValue(generator = "JDBC")
    private Integer gid;

    @Column(name = "gname")
    private String gname;

    @Column(name = "cid")
    private Integer cid;

    private School school;
}
