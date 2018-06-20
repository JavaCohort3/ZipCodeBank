
package com.example.javacohort3.ZipCodeBank;

import com.example.javacohort3.ZipCodeBank.controllers.BillController;
import com.example.javacohort3.ZipCodeBank.domains.Bill;
import com.example.javacohort3.ZipCodeBank.services.BillService;
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
//public class BillControllerTest {
//
//    @Mock
//    BillService billService;
//
//
//    @Before
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void getBillById(){
//        BillController controller = new BillController(new BillService());
//        Bill bill = new Bill();
//        ReflectionTestUtils.setField(controller, "billService", billService);
//        when(billService.getBillById(bill.getAccountId())).thenReturn(bill);
//        ResponseEntity<?> billById = controller.getBillById(bill.getAccountId());
//        verify(billService,times(1)).getBillById(bill.getAccountId());
//        Assert.assertEquals(HttpStatus.OK,billById.getStatusCode());
//
//    }
//
//    @Test
//    public void getBillByAccountId(){
//        BillController controller = new BillController(new BillService());
//        Bill bill = new Bill();
//        ReflectionTestUtils.setField(controller, "billService", billService);
//        when(billService.getAllBillByAccountId(bill.getAccount_id())).thenReturn(new ArrayList<>());
//        ResponseEntity<?> accountBill = controller.getBillByAccountId(bill.getAccount_id());
//        verify(billService,times(1)).getAllBillByAccountId(bill.getAccount_id());
//        Assert.assertEquals(HttpStatus.OK,accountBill.getStatusCode());
//
//    }
//
//
//    @Test
//    public void getBillByCustomerId(){
//        BillController controller = new BillController(new BillService());
//        Long id = 0L;
//        ReflectionTestUtils.setField(controller, "billService", billService);
//        when(billService.getBillsByCustomerId(id)).thenReturn(new ArrayList<>());
//        ResponseEntity<?> billByCustomerId = controller.getBillByCustomerId(id);
//        verify(billService,times(1)).getBillsByCustomerId(id);
//        Assert.assertEquals(HttpStatus.OK,billByCustomerId.getStatusCode());
//    }
//
//    @Test
//    public void deleteBill(){
//        BillController controller = new BillController(new BillService());
//        Bill bill = new Bill();
//        ReflectionTestUtils.setField(controller, "billService", billService);
//        billService.deleteBill(bill.getAccountId());
//        when(billService.getBillById(bill.getAccountId())).thenReturn(null);
//        ResponseEntity<?> billDelete = controller.deleteBill(bill.getAccountId());
//        verify(billService,times(2)).deleteBill(bill.getAccountId());
//        Assert.assertEquals(HttpStatus.NO_CONTENT,billDelete.getStatusCode());
//    }
//
//    @Test
//    public void createBill(){
//        BillController controller = new BillController(new BillService());
//        Bill bill = new Bill();
//        ReflectionTestUtils.setField(controller, "billService", billService);
//        when(billService.createBill(bill,bill.getAccount_id())).thenReturn(bill);
//        ResponseEntity<?> personList = controller.createBill(bill,bill.getAccount_id());
//        verify(billService,times(1)).createBill(bill,bill.getAccount_id());
//        Assert.assertEquals(HttpStatus.CREATED,personList.getStatusCode());
//
//    }
//
//    @Test
//    public void updateBillIfBillDoNotExist(){
//        BillController controller = new BillController(new BillService());
//        Bill bill = new Bill();
//        ReflectionTestUtils.setField(controller, "billService", billService);
//        when(billService.updateBill(bill)).thenReturn(new Bill());
//        ResponseEntity<?> update = controller.updateBill(bill,bill.getAccountId());
//        verify(billService,times(1)).updateBill(bill);
//        Assert.assertEquals(HttpStatus.CREATED,update.getStatusCode());
//    }
//
//
//}
//
