package xyz.taoqz.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "school")
public class School implements Serializable {
    @Id
    @Column(name = "cid")
    @GeneratedValue(generator = "JDBC")
    private Integer cid;

    @Column(name = "cname")
    private String cname;
}
