package com.controller.employees;

import com.dao.DaoException;
import com.dao.EmployeeDAO;
import com.model.Employee;
import org.codehaus.jackson.map.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeDAO employeeDAO;



    //перейти к рабате с сотрудниками
    @RequestMapping(value = "/employees/menu")
    public String employeesMenu (){
        return "views/employee/jobEmployees";
    }

    @RequestMapping(value = "/employee/getEmployeesList", method = RequestMethod.GET)
    public String getEmployeesList(Model model) throws DaoException, IOException {

//        ObjectMapper objectMapper = new ObjectMapper();
//        model.addAttribute("listEmployees",objectMapper.writeValueAsString(employeeDAO.getAll()));
        model.addAttribute("listEmployees", this.employeeDAO.getAll());
        return "views/employee/employeeListDisplay";
//        return objectMapper.writeValueAsString(employeeDAO.getAll());
    }





}
