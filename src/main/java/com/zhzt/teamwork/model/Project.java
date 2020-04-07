package com.zhzt.teamwork.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;


/**
 * Project 项目实体
 * */
@Entity
public class Project {

    /** ID编号 */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** 名称 */
    @Column(unique = true)
    @NotBlank(message = "name can not be blank")
    @Size(min=2, max=30, message = "名称个数必须在2到30之间")
    private String name;

    /** 项目描述*/
    private String description;

    /** 创建时间 */
    private Date createTime;

    public Project() {
        this.createTime = Calendar.getInstance().getTime();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
