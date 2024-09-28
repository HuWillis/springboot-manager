package com.company.project.emp;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.company.project.entity.EmpAttendanceEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AttendanceImportListener extends AnalysisEventListener<Map<Integer, String>> {


    private final List<EmpAttendanceEntity> statisticsList = new ArrayList<>();
    private final List<String> headers = new ArrayList<>();

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        // 收集表头
        if (headers.isEmpty()) {
            headers.addAll(data.values());
            return;
        }

        // 创建 AttendanceStatistics 对象并填充数据
        EmpAttendanceEntity stat = new EmpAttendanceEntity();
        stat.setEmployeeId(Long.valueOf(data.get(0))); // 假设第一列是员工ID
//        stat.setEmployeeName(data.get(1)); // 假设第二列是姓名
//        stat.setDepartment(data.get(2)); // 假设第三列是部门

        // 填充动态日期数据
        for (int i = 3; i < headers.size(); i++) {
            String date = headers.get(i);
            String status = data.get(i);
//            stat.setStatusByDate(date, status);
        }

        statisticsList.add(stat);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("导入完成，总记录数: " + statisticsList.size());
    }

    public List<EmpAttendanceEntity> getStatisticsList() {
        return statisticsList;
    }

    public List<String> getHeaders() {
        return headers;
    }

}
