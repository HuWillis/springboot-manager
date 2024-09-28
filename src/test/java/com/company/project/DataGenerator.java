package com.company.project;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.Random;

public class DataGenerator {

    public static void main(String[] args) {
        // 替换为你的数据库URL
        String url = "jdbc:mysql://localhost:3306/manager";
        String user = "root"; // 替换为你的数据库用户名
        String password = "123456"; // 替换为你的数据库密码

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // 插入员工数据
            String insertEmployeeSQL = "INSERT INTO emp_employee "
                + "(employee_id,name, department, position, hire_date, email, phone, tenant_id, created_by, created_by_name)"
                + " VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement employeeStatement = connection.prepareStatement(insertEmployeeSQL);

            String[] names = {"张三", "李四", "王五", "赵六", "钱七"};
            String[] departments = {"IT", "HR", "财务", "市场"};
            Map<String, String> idMap = MapUtil.newHashMap();
            Map<String, String> postMap = MapUtil.newHashMap();

            for (String name : names) {
                String key = idMap.get(name);
                if (StrUtil.isBlank(key)) {
                    key = IdWorker.getIdStr();
                    idMap.put(name, key);
                }

                String post = postMap.get(name);
                if (StrUtil.isBlank(post)) {
                    post = RandomUtil.randomNumbers(1);
                    postMap.put(name, post);
                }

                employeeStatement.setString(1, key);
                employeeStatement.setString(2, name);
                employeeStatement.setString(3,
                    departments[new Random().nextInt(departments.length)]);
                employeeStatement.setString(4, "职务" + post);
                employeeStatement.setDate(5, java.sql.Date.valueOf("2022-01-01"));
                employeeStatement.setString(6, "example" + post + "@example.com");
                employeeStatement.setString(7, "1234567890" + post);
                employeeStatement.setLong(8, 1);
                employeeStatement.setLong(9, 1);
                employeeStatement.setString(10, "管理员");
                employeeStatement.addBatch();
            }

            employeeStatement.executeBatch();

            // 插入考勤数据
            String insertAttendanceSQL = "INSERT INTO emp_attendance "
                + "(attendance_id,employee_id, date, status, check_in_time, check_out_time, tenant_id, created_by, created_by_name)"
                + " VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement attendanceStatement = connection.prepareStatement(
                insertAttendanceSQL);

            for (String name : names) {
                String key = idMap.get(name);
                for (int j = 1; j <= 30; j++) {
                    attendanceStatement.setString(1, IdWorker.getIdStr());
                    attendanceStatement.setString(2, key);
                    attendanceStatement.setDate(3,
                        java.sql.Date.valueOf("2024-09-" + String.format("%02d", j)));
                    attendanceStatement.setString(4, new Random().nextBoolean() ? "出勤" : "缺勤");
                    attendanceStatement.setString(5, "09:00");
                    attendanceStatement.setString(6, "18:00");
                    attendanceStatement.setLong(7, 1);
                    attendanceStatement.setLong(8, 1);
                    attendanceStatement.setString(9, "管理员");
                    attendanceStatement.addBatch();
                }
            }
            attendanceStatement.executeBatch();

            System.out.println("数据插入完成！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

