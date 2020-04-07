package com.zhzt.teamwork.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/** 项目员工表 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name="PRJ_EMP_GROUP", columnNames = {"projectId", "employeeId"}))
public class ProjectEmployeeList {
    /**id*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**项目id*/
    @NotNull
    private Long projectId;

    /**员工id*/
    @NotNull
    private Long employeeId;

    public ProjectEmployeeList() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
