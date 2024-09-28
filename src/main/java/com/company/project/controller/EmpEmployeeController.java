package com.company.project.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaIgnore;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.company.project.common.utils.DataResult;
import com.company.project.entity.EmpEmployeeEntity;
import com.company.project.service.EmpEmployeeService;
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
 * 员工表
 *
 * @author wenbin
 * @email *****@mail.com
 * @date 2024-09-28 21:56:23
 */
@Controller
@RequestMapping("/")
@SaIgnore
public class EmpEmployeeController {

    @Autowired
    private EmpEmployeeService empEmployeeService;

    /**
     * 跳转到页面
     */
    @GetMapping("/index/empEmployee")
    public String empEmployee() {
        return "empemployee/list";
    }


    @ApiOperation(value = "查询分页数据")
    @PostMapping("empEmployee/listByPage")
    @SaCheckPermission("empEmployee:list")
    @ResponseBody
    public DataResult findListByPage(@RequestBody EmpEmployeeEntity empEmployee) {
        LambdaQueryWrapper<EmpEmployeeEntity> queryWrapper = Wrappers.lambdaQuery();
        //查询条件示例
//        queryWrapper.eq(tbGoods.getId() != null, EmpEmployeeEntity::getId, empEmployee.getId());
//        queryWrapper.orderByDesc(EmpEmployeeEntity::getId);
        IPage<EmpEmployeeEntity> iPage = empEmployeeService.page(empEmployee.getQueryPage(),
            queryWrapper);
        return DataResult.success(iPage);
    }


    @ApiOperation(value = "新增")
    @PostMapping("empEmployee/add")
    @SaCheckPermission("empEmployee:add")
    @ResponseBody
    public DataResult add(@RequestBody EmpEmployeeEntity empEmployee) {
        empEmployeeService.save(empEmployee);
        return DataResult.success();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("empEmployee/delete")
    @SaCheckPermission("empEmployee:delete")
    @ResponseBody
    public DataResult delete(@RequestBody @ApiParam(value = "id集合") List<String> ids) {
        empEmployeeService.removeByIds(ids);
        return DataResult.success();
    }

    @ApiOperation(value = "更新")
    @PutMapping("empEmployee/update")
    @SaCheckPermission("empEmployee:update")
    @ResponseBody
    public DataResult update(@RequestBody EmpEmployeeEntity empEmployee) {
        empEmployeeService.updateById(empEmployee);
        return DataResult.success();
    }


}
