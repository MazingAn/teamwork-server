package com.zhzt.teamwork.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * 员工实体类
 * */
@Entity
public class Employee {
    /**id*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**员工姓名*/
    @Size(max = 32, min = 2, message = "名称长度必须介于2到32之间")
    private String name;

    /**员工title*/
    @Size(max = 32, min = 2, message = "职务长度必须介于2到32之间")
    private String jobTitle;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
