package com.company.project.emp;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.company.project.entity.EmpAttendanceEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendanceExport {

    public static void exportAttendanceStatistics(List<EmpAttendanceEntity> statistics,
        List<String> headers,
        String fileName,
        int year,
        int month) {
        List<List<String>> head = new ArrayList<>();

        // 添加固定表头
        for (String header : headers) {
            head.add(new ArrayList<>(ListUtil.of(header, header))); // 添加员工ID、姓名、部门
        }

        // 动态生成日期和对应星期的表头
        Date firstOfMonth = DateUtil.beginOfMonth(DateUtil.parseDate(year + "-" + month + "-01"));
        Date lastOfMonth = DateUtil.endOfMonth(firstOfMonth);

        // 遍历每一天
        for (Date date = firstOfMonth; !date.after(lastOfMonth);
            date = DateUtil.offsetDay(date, 1)) {
            String dateStr = DateUtil.format(date, DatePattern.NORM_DATE_FORMATTER);
            Week week = DateUtil.dayOfWeekEnum(date); // 获取对应星期
            head.add(new ArrayList<>(ListUtil.of(dateStr, week.toChinese())));
        }

        // 导出 Excel 文件
        EasyExcel.write(fileName, EmpAttendanceEntity.class)
            .sheet("考勤统计")
            .head(head) // 设置动态表头
            .doWrite(statistics);
    }

    public static void main(String[] args) {
        // 示例数据，通常你会从数据库或其他地方获取这些数据
        List<EmpAttendanceEntity> statistics = new ArrayList<>();
        List<String> headers = ListUtil.of("员工ID", "姓名", "部门");

        // 设置要导出的年份和月份
        int year = 2024;
        int month = 9;

        // 导出到 Excel 文件
        String exportFileName = "考勤统计_" + IdWorker.getIdStr() + ".xlsx";
        exportAttendanceStatistics(statistics, headers, exportFileName, year, month);
        System.out.println("导出完成，文件名：" + exportFileName);
    }
}
