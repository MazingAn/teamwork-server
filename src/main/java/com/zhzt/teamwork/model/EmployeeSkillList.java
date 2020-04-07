package com.zhzt.teamwork.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "EMP_SKILL_GROUP", columnNames = {"skillId", "employeeId"}))
public class EmployeeSkillList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private long employeeId;

    @NotNull
    private long skillId;

    @Min(value = 0,message = "技能熟练度最低不得低于0")
    @Max(value = 100, message = "技能熟练度最高不得超过100")
    private int score;
}
