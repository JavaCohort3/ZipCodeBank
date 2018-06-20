package com.example.javacohort3.ZipCodeBank;

import com.example.javacohort3.ZipCodeBank.controllers.CustomerController;
import com.example.javacohort3.ZipCodeBank.domains.Customer;
import com.example.javacohort3.ZipCodeBank.services.CustomerService;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootConfiguration
//@WebAppConfiguration
//public class CustomerControllerTests {
//
//
//
//    @Mock
//    private CustomerService customerService;
//
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void getCustomerByAccountIdTest() {
//        CustomerController controller = new CustomerController(new CustomerService());
//        Customer customer = new Customer();
//
//        ReflectionTestUtils.setField(controller, "customerService", customerService);
//        when(customerService.getCustomerByAccountId(customer.getAccountId())).thenReturn(customer);
//
//        ResponseEntity<?> getCustomerByAccount = controller.getCustomerByAccountId(customer.getAccountId());
//        verify(customerService, times(1)).getCustomerByAccountId(customer.getAccountId());
//
//        Assert.assertEquals(HttpStatus.OK, getCustomerByAccount.getStatusCode());
//    }
//
//    @Test
//    public void getAllCustomersTest() {
//        CustomerController controller = new CustomerController(new CustomerService());
//        ReflectionTestUtils.setField(controller, "customerService", customerService);
//
//        when(customerService.getAllCustomers()).thenReturn(new ArrayList<>());
//        ResponseEntity<?> getAllCustomers = controller.getAllCustomers();
//
//        verify(customerService, times(1)).getAllCustomers();
//
//        Assert.assertEquals(HttpStatus.OK, getAllCustomers.getStatusCode());
//        Assert.assertEquals(1, Lists.newArrayList(getAllCustomers.getBody()).size());
//    }
//
//    @Test
//    public void getCustomerByIdTest() {
//        CustomerController controller = new CustomerController(new CustomerService());
//        Customer customer = new Customer();
//
//        ReflectionTestUtils.setField(controller, "customerService", customerService);
//        when(customerService.getCustomerById(customer.getAccountId())).thenReturn(customer);
//
//        ResponseEntity<?> getCustomerByID = controller.getCustomerById(customer.getAccountId());
//        verify(customerService, times(1)).getCustomerById(customer.getAccountId());
//
//        Assert.assertEquals(HttpStatus.OK, getCustomerByID.getStatusCode());
//    }
//
//    @Test
//    public void createCustomerTest() {
//        CustomerController controller = new CustomerController(new CustomerService());
//        Customer customer = new Customer();
//
//        ReflectionTestUtils.setField(controller, "customerService", customerService);
//        when(customerService.createCustomer(customer)).thenReturn(new Customer());
//
//        ResponseEntity<?> createCustomer = controller.createCustomer(customer);
//        verify(customerService, times(1)).createCustomer(customer);
//
//        Assert.assertEquals(HttpStatus.CREATED, createCustomer.getStatusCode());
//    }
//
//    @Test
//    public void updateCustomerTest() {
//        CustomerController controller = new CustomerController(new CustomerService());
//        Customer customer = new Customer();
//        //customer.setAccountId((long) 888);
//
//        ReflectionTestUtils.setField(controller, "customerService", customerService);
//        when(customerService.updateCustomer(customer, customer.getAccountId())).thenReturn(customer);
//
//        ResponseEntity<?> updateCustomer = controller.updateCustomer(customer, customer.getAccountId());
//        verify(customerService, times(1)).updateCustomer(customer, customer.getAccountId());
//
//        Assert.assertEquals(HttpStatus.OK, updateCustomer.getStatusCode());
//    }
//
//}
