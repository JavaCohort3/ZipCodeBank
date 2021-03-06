//package com.example.javacohort3.ZipCodeBank;
//
//import com.example.javacohort3.ZipCodeBank.controllers.BillController;
//import com.example.javacohort3.ZipCodeBank.domains.Bill;
//import com.example.javacohort3.ZipCodeBank.services.BillService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.util.ReflectionTestUtils;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
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
//        when(billService.getBillById(bill.getId())).thenReturn(bill);
//        ResponseEntity<?> billById = controller.getBillById(bill.getId());
//        verify(billService,times(1)).getBillById(bill.getId());
//        Assert.assertEquals(HttpStatus.OK,billById.getStatusCode());
//
//    }
//
//    @Test
//    public void getBillByAccountId(){
//        BillController controller = new BillController(new BillService());
//        Bill bill = new Bill();
//        ReflectionTestUtils.setField(controller, "billService", billService);
//        when(billService.getAllBillByAccountId(bill.getAccountId())).thenReturn(new ArrayList<>());
//        ResponseEntity<?> accountBill = controller.getBillByAccountId(bill.getAccountId());
//        verify(billService,times(1)).getAllBillByAccountId(bill.getAccountId());
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
//        billService.deleteBill(bill.getId());
//        when(billService.getBillById(bill.getId())).thenReturn(null);
//        ResponseEntity<?> billDelete = controller.deleteBill(bill.getId());
//        verify(billService,times(2)).deleteBill(bill.getId());
//        Assert.assertEquals(HttpStatus.NO_CONTENT,billDelete.getStatusCode());
//    }
//
//    @Test
//    public void createBill(){
//        BillController controller = new BillController(new BillService());
//        Bill bill = new Bill();
//        ReflectionTestUtils.setField(controller, "billService", billService);
//        when(billService.createBill(bill,bill.getAccountId())).thenReturn(bill);
//        ResponseEntity<?> personList = controller.createBill(bill,bill.getAccountId());
//        verify(billService,times(1)).createBill(bill,bill.getAccountId());
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
//        ResponseEntity<?> update = controller.updateBill(bill,bill.getId());
//        verify(billService,times(1)).updateBill(bill);
//        Assert.assertEquals(HttpStatus.CREATED,update.getStatusCode());
//    }
//
//
//}
//
