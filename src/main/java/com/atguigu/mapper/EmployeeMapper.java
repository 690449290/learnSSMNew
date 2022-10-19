package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmployee();

    void deleteEmployeeById(@Param("id") Integer id);

    Employee getEmployeeById(@Param("id") Integer id);

    void updateEmployee(@Param("employee") Employee employee);

    void addEmployee(@Param("employee") Employee employee);
}