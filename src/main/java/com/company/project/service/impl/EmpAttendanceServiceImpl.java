package com.company.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.project.entity.EmpAttendanceEntity;
import com.company.project.mapper.EmpAttendanceMapper;
import com.company.project.service.EmpAttendanceService;
import org.springframework.stereotype.Service;


@Service("empAttendanceService")
public class EmpAttendanceServiceImpl extends
    ServiceImpl<EmpAttendanceMapper, EmpAttendanceEntity> implements EmpAttendanceService {


}