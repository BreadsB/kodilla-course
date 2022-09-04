package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeDaoTestSuite {

    @Autowired
    EmployeeDao employeeDao;


    @Test
    void testFindEmployeeByName() {
        Employee employee1 = new Employee("Mike", "Tyson");

        employeeDao.save(employee1);

        List<Employee> employees = employeeDao.retrieveEmployeeByLastName("Tyson");

        Assertions.assertEquals(1, employees.size());

        employeeDao.deleteById(employee1.getId());
    }
}
