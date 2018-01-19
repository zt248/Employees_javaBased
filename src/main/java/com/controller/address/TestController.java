package com.controller.address;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.dao.AddressDAO;
import com.dao.DaoException;
import com.model.Address;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class TestController {

    @Autowired
    private AddressDAO addressDao;

    @RequestMapping(value="/viewemp/{pageid}")
    public ModelAndView edit(@PathVariable int pageid){
        int total=10;
        if(pageid==1){
            pageid = pageid -1;
        }
        else{
            pageid=(pageid-1)*total;
        }
        List<Address> list=addressDao.getEmployeesByPage(pageid,total);

        return new ModelAndView("/views/viewemp","list",list);
    }


    @RequestMapping(value = "/getListTestAjax", method = RequestMethod.GET)
    public String listAddressAjax(Model model) throws DaoException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        model.addAttribute("addressList", objectMapper.writeValueAsString(addressDao.getAll()));
        return "views/testView";
    }


}
