package com.company.project.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.company.project.common.utils.DataResult;
import com.company.project.entity.EmpAttendanceEntity;
import com.company.project.service.EmpAttendanceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 员工考勤表
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2024-09-28 21:56:22
 */
@Controller
@RequestMapping("/")
@SaIgnore
public class EmpAttendanceController {

    @Autowired
    private EmpAttendanceService empAttendanceService;

    /**
     * 跳转到页面
     */
    @GetMapping("/index/empAttendance")
    public String empAttendance() {
        return "empattendance/list";
    }


    @ApiOperation(value = "查询分页数据")
    @PostMapping("empAttendance/listByPage")
    @SaCheckPermission("empAttendance:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody EmpAttendanceEntity empAttendance) {
        LambdaQueryWrapper<EmpAttendanceEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
//        queryWrapper.eq(tbGoods.getId() != null, EmpAttendanceEntity::getId, empAttendance.getId());
//        queryWrapper.orderByDesc(EmpAttendanceEntity::getId);
        IPage<EmpAttendanceEntity> iPage = empAttendanceService.page(empAttendance.getQueryPage(),
            queryWrapper);
        return DataResult.success(iPage);
    }


    @ApiOperation(value = "新增")
    @PostMapping("empAttendance/add")
    @SaCheckPermission("empAttendance:add")
    @ResponseBody
    public DataResult add(@RequestBody EmpAttendanceEntity empAttendance) {
        empAttendanceService.save(empAttendance);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("empAttendance/delete")
    @SaCheckPermission("empAttendance:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids) {
        empAttendanceService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("empAttendance/update")
    @SaCheckPermission("empAttendance:update")
    @ResponseBody
    public DataResult update(@RequestBody EmpAttendanceEntity empAttendance) {
        empAttendanceService.updateById(empAttendance);
        return DataResult.success();
    }


}
