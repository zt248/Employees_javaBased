package com.controller.employees;

import com.dao.DaoException;
import com.dao.EmployeeDAO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeDAO employeeDAO;



    @RequestMapping(value = "/employee/getEmployeesList", method = RequestMethod.GET)
    public String getEmployeesList(Model model) throws DaoException, IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        model.addAttribute("listEmployees",objectMapper.writeValueAsString(employeeDAO.getAll()));
        model.addAttribute("listEmployees", this.employeeDAO.getAll());
        return "views/employee/employeeListDisplay";
//        return objectMapper.writeValueAsString(employeeDAO.getAll());
    }


}
