package com.atguigu.pojo;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Date 2022/10/17 19:55
 * @Author JUN ZHOU
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
    private Integer empId;
    private String empName;
    private Integer age;
    private String sex;
    private String email;
}