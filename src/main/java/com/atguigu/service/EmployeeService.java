package com.atguigu.service;

import com.atguigu.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface EmployeeService {
    /**
     * @return 获取所有的员工信息
     */
    List<Employee> getAllEmployee();

    /**
     * @return 获取员工的分页信息
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    void deleteEmployeeById(Integer id);

    Employee getEmployeeById(Integer id);

    void updateEmployee(Employee employee);

    void addEmployee(Employee employee);
}