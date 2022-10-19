package com.atguigu.controller;

import com.atguigu.pojo.Employee;
import com.atguigu.service.EmployeeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description
 * 查询所有员工信息 /employee -->get
 * 查询员工的分页信息 /employee/page/1 -->get
 * 根据id查询员工信息 /employee/1 -->get
 * 跳转到添加页面 /to/add -->get
 * 添加员工信息 /employee -->post
 * 修改员工信息 /employee -->put
 * 根据id删除员工信息 /employee/1 -->delete
 * @Date 2022/10/17 18:44
 * @Author JUN ZHOU
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/page/{pageNum}")
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, Model model){
        //获取员工的分页信息
        PageInfo<Employee> pageInfo = employeeService.getEmployeePage(pageNum);
        //将分页数据共享到请求域
        model.addAttribute("pageInfo", pageInfo);
        //跳转到employee_list.html
        return "employee_list";
    }

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> list = employeeService.getAllEmployee();
        //将员工信息共享到请求域中
        model.addAttribute("list", list);
        //跳转到employee_list.html
        return "employee_list";
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee/page/1";
    }
    @PutMapping("/employee/modify/{id}")
    public String modifyEmployee(@PathVariable("id") Integer id, Model model){
        Employee emp = employeeService.getEmployeeById(id);
        model.addAttribute("emp", emp);
        return "modify";
    }
    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/1";
    }
    @GetMapping("/employee/add")
    public String toAdd(){
        return "add";
    }
    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employee/page/1";
    }
}