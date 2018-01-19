package com;

import com.config.ApplicationConfig;
import com.dao.DaoException;
import com.dao.EmployeeDAO;
import com.dao.impl.AddressDaoImpl;
import com.dao.impl.DepartmentDaoImpl;
import com.dao.impl.EmployeeDaoImpl;
import com.model.Address;
import com.model.Department;
import com.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws DaoException {



        ApplicationContext context  = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//            AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();
//            context2.scan("com");



        EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean(EmployeeDAO.class);
//        DepartmentDaoImpl departmentDAO = context.getBean(DepartmentDaoImpl.class);
//        AddressDaoImpl addressDAO = context.getBean(AddressDaoImpl.class);


        Address address = new Address();
        address.setCity("Минск");
        address.setCountry("Беларусь");
        address.setPostCode("244123");
        address.setStreet("Фогеля 1Е");


        Department department = new Department();
        department.setTitle("Грузчик ТЦ Уручье");

        Employee employee = new Employee();

        employee.setBirthday(new Date(28, 4, 92));
        employee.setLastName("Евгений");
        employee.setFirstName("Царик");
        employee.setAddress(address);

        Set<Department> departmentList = new HashSet<>();
        departmentList.add(department);
        employee.setDepartments(departmentList);

        employeeDAO.add(employee);
//        departmentDAO.add(department);
//        addressDAO.add(address);
    }
}
