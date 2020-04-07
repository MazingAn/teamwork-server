package com.zhzt.teamwork.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * 员工技能实体类
 * */
@Entity
public class Skill {
    /**技能id*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** 技能名称 */
    @Column(unique = true)
    @Size(min = 2, max = 32, message="名称长度必须介于2到32之间")
    private String name;

    /** 技能引用次数 */
    @Min(value = 0)
    private int count;
}
