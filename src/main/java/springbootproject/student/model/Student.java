package springbootproject.student.model;

import javax.persistence.*;

/**
 * @User: 陈祖威
 * @Date: 2019/7/29
 * @Time: 17:02
 * @Version: 1.0
 */
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private Integer sno;
    @Column
    private String stu_name;
    @Column
    private Byte stu_sex;
    @Column
    private Integer stu_age;
    @Column
    private String class_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public Byte getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(Byte stu_sex) {
        this.stu_sex = stu_sex;
    }

    public Integer getStu_age() {
        return stu_age;
    }

    public void setStu_age(Integer stu_age) {
        this.stu_age = stu_age;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
