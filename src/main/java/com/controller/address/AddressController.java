package com.controller.address;

import com.dao.DaoException;
import com.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.service.AddressService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    //Переход к работе с адресами
    @RequestMapping(value = "/address/menu", method = RequestMethod.GET)
    public String addressMenu() {
        return "views/address/jobAddress";
    }

    //Чтение записей
    @RequestMapping(value = "/address/getListAddress", method = RequestMethod.GET)
    public String listAddress(Model model) throws DaoException {
        model.addAttribute("listAddress", this.addressService.getAll());
        return "views/address/addressListDisplay";
    }

//    @RequestMapping(value = "/address/getListAddressAjax", method = RequestMethod.GET)
//    @ResponseBody
//    public String listAddressAjax() throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(addressService.getAll());
//    }


    @RequestMapping(value = "/address/byIdAddress", method = RequestMethod.GET)
    public ModelAndView byIdAddress() {
        return new ModelAndView("views/address/byIdAddress", "command", new Address());
    }

    @RequestMapping(value = "/address/getByIdAddress", method = RequestMethod.POST)
    public String getByIdAddress(@ModelAttribute("address") Address address, Model model) throws DaoException {
        model.addAttribute("id", this.addressService.getById(address.getId()).getId());
        model.addAttribute("country", this.addressService.getById(address.getId()).getCountry());
        model.addAttribute("city", this.addressService.getById(address.getId()).getCity());
        model.addAttribute("street", this.addressService.getById(address.getId()).getStreet());
        model.addAttribute("postCode", this.addressService.getById(address.getId()).getPostCode());
        return "views/address/getByIdAddress";
    }

    //Добавление записи
    @RequestMapping(value = "/address/newAddress", method = RequestMethod.GET)
    public ModelAndView newAddress() {
        return new ModelAndView("views/address/newAddress", "command", new Address());
    }


    @RequestMapping(value = "/address/addAddress", method = RequestMethod.POST)
    public String addAddress(@ModelAttribute("address") Address address, Model model) throws DaoException {
        model.addAttribute("country", address.getCountry());
        model.addAttribute("city", address.getCity());
        model.addAttribute("street", address.getStreet());
        model.addAttribute("postCode", address.getPostCode());
        this.addressService.add(address);
        return "redirect:/address/getListAddress";
    }


    /*добавление с помощью Ajax*/
    @RequestMapping(value = "/address/addSt-ajax", method = RequestMethod.POST)
    @ResponseBody
    public String addAddressAjax(HttpServletRequest request, Address address) throws DaoException {
        addressService.add(address);
//        return address.toString();
        return "redirect:/address/getListAddress";
    }


    //Редактирование записи
    @RequestMapping(value = "/address/updateAddress", method = RequestMethod.GET)
    public ModelAndView updateAddress() {
        return new ModelAndView("/views/address/updateAddress", "command", new Address());
    }

    @RequestMapping(value = "/address/getUpdateAddress", method = RequestMethod.POST)
    public String getUpdateAddress(@ModelAttribute("address") Address address, Model model) throws DaoException {
        model.addAttribute("id", address.getId());
        model.addAttribute("country", address.getCountry());
        model.addAttribute("city", address.getCity());
        model.addAttribute("street", address.getStreet());
        model.addAttribute("postCode", address.getPostCode());
        this.addressService.update(address);
        return "redirect:/address/getListAddress";
    }

    //Удаление записи
    @RequestMapping(value = "/address/deleteByIdAddress", method = RequestMethod.GET)
    public ModelAndView deleteByIdAddress() {
        return new ModelAndView("views/address/deleteByIdAddress", "command", new Address());
    }

    @RequestMapping(value = "/address/removeByIdAddress", method = RequestMethod.POST)
    public String removeByIdAddress(@ModelAttribute("address") Address address, Model model) throws DaoException {
        model.addAttribute("id", address.getId());
        this.addressService.remove(address);
        return "redirect:/address/getListAddress";
    }


    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id) throws DaoException {
        Address address = new Address();
        address.setId(id);
        this.addressService.remove(address);
        return "redirect:/address/getListAddress";
    }
}
