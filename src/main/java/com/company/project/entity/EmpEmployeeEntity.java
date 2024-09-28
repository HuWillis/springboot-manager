package com.company.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工表
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2024-09-28 21:56:23
 */
@Data
@TableName("emp_employee")
public class EmpEmployeeEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工唯一标识符
     */
    @TableId("employee_id")
    private Long employeeId;

    /**
     * 员工姓名
     */
    @TableField("name")
    private String name;

    /**
     * 所属部门
     */
    @TableField("department")
    private String department;

    /**
     * 职位
     */
    @TableField("position")
    private String position;

    /**
     * 入职日期
     */
    @TableField("hire_date")
    private Date hireDate;

    /**
     * 电子邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 联系电话
     */
    @TableField("phone")
    private String phone;

    /**
     * 逻辑删除标识
     */
    @TableField("is_deleted")
    private Integer isDeleted;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private Long tenantId;

    /**
     * 创建人ID
     */
    @TableField("created_by")
    private Long createdBy;

    /**
     * 创建人姓名
     */
    @TableField("created_by_name")
    private String createdByName;

    /**
     * 创建时间
     */
    @TableField("created_at")
    private Date createdAt;

    /**
     * 修改人ID
     */
    @TableField("updated_by")
    private Long updatedBy;

    /**
     * 修改人姓名
     */
    @TableField("updated_by_name")
    private String updatedByName;

    /**
     * 修改时间
     */
    @TableField("updated_at")
    private Date updatedAt;


}
