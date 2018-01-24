package com.dao.impl;

import com.config.ApplicationConfig;
import com.dao.AddressDAO;
import com.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class AddressDaoImplTest {

    @Autowired
    private AddressDAO addressDAO;


    @Test
    public void add() {
        Address address = new Address();
        address.setStreet("street");
        address.setPostCode("123");
        address.setCountry("c");

    }

    @Test
    public void getAll() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void remove() {
    }
}