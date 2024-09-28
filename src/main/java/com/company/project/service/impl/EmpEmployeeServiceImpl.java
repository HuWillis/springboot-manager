package com.company.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.entity.EmpEmployeeEntity;
import com.company.project.mapper.EmpEmployeeMapper;
import com.company.project.service.EmpEmployeeService;
import org.springframework.stereotype.Service;


@Service("empEmployeeService")
public class EmpEmployeeServiceImpl extends
    ServiceImpl<EmpEmployeeMapper, EmpEmployeeEntity> implements EmpEmployeeService {


}