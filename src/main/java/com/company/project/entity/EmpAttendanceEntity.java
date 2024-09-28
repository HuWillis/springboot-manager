package com.company.project.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 员工考勤表
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2024-09-28 21:56:22
 */
@Data
@TableName("emp_attendance")
public class EmpAttendanceEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 考勤唯一标识符
     */
    @TableId("attendance_id")
    private Long attendanceId;

    /**
     * 员工ID
     */
    @TableField("employee_id")
    private Long employeeId;

    /**
     * 考勤日期
     */
    @TableField("date")
    private Date date;

    /**
     * 考勤状态
     */
    @TableField("status")
    private String status;

    /**
     * 签到时间
     */
    @TableField("check_in_time")
    private Date checkInTime;

    /**
     * 签退时间
     */
    @TableField("check_out_time")
    private Date checkOutTime;

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
