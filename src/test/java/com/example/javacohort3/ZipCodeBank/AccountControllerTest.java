//package com.example.javacohort3.ZipCodeBank;
//
//
//import com.example.javacohort3.ZipCodeBank.controllers.AccountController;
//import com.example.javacohort3.ZipCodeBank.domains.Account;
//import com.example.javacohort3.ZipCodeBank.services.AccountService;
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
//public class AccountControllerTest {
//
//    @Mock
//    AccountService accountService;
//
//    @Before
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void getAllAccounts(){
//        AccountController controller = new AccountController(new AccountService());
//        Account account = new Account();
//        ReflectionTestUtils.setField(controller, "accountService", accountService);
//        when(accountService.getAllAccounts()).thenReturn(new ArrayList<>());
//        ResponseEntity<?> accounts = controller.getAllAccounts();
//        verify(accountService, times(1)).getAllAccounts();
//        Assert.assertEquals(HttpStatus.OK, accounts.getStatusCode());
//
//    }
//
//    @Test
//    public void getAccountById(){
//        AccountController controller = new AccountController(new AccountService());
//        Account account = new Account();
//        ReflectionTestUtils.setField(controller, "accountService", accountService);
//        when(accountService.getAccountById(account.getAccountId())).thenReturn(account);
//        ResponseEntity<?> accountById = controller.getAccountByID(account.getAccountId());
//        verify(accountService, times(1)).getAccountById(account.getAccountId());
//        Assert.assertEquals(HttpStatus.OK, accountById.getStatusCode());
//    }
//
//    @Test
//    public void getAllAccountsByCustomerId(){
//        AccountController controller = new AccountController(new AccountService());
//        Long id = 0L;
//        ReflectionTestUtils.setField(controller, "accountService", accountService);
//        when(accountService.getAllAccountsByCustomerId(id)).thenReturn(new ArrayList<>());
//        ResponseEntity<?> accountCustomer = controller.getAllAccountsByCustomerId(id);
//        verify(accountService, times(1)).getAllAccountsByCustomerId(id);
//        Assert.assertEquals(HttpStatus.OK, accountCustomer.getStatusCode());
//    }
//
//    @Test
//    public void createAccountFromCustomerId(){
//        AccountController controller = new AccountController(new AccountService());
//        Account account = new Account();
//        ReflectionTestUtils.setField(controller, "accountService", accountService);
//        when(accountService.createAccountFromCustomerId(account, account.getAccountId())).thenReturn(account);
//        ResponseEntity<?> personList = controller.createAccountFromCustomerId(account, account.getAccountId());
//        verify(accountService, times(1)).createAccountFromCustomerId(account, account.getAccountId());
//        Assert.assertEquals(HttpStatus.CREATED, personList.getStatusCode());
//    }
//
//    @Test
//    public void deleteAccountById(){
//        AccountController controller = new AccountController(new AccountService());
//        Account account = new Account();
//        ReflectionTestUtils.setField(controller, "accountService", accountService);
//        accountService.deleteAccountById(account.getAccountId());
//        when(accountService.getAccountById(account.getAccountId())).thenReturn(null);
//        ResponseEntity<?> accountDelete = controller.deleteAccountById(account.getAccountId());
//        verify(accountService, times(2)).deleteAccountById(account.getAccountId());
//        Assert.assertEquals(HttpStatus.NO_CONTENT, accountDelete.getStatusCode());
//    }
//
//    @Test
//    public void updateAccount(){
//        AccountController controller = new AccountController(new AccountService());
//        Account account = new Account();
//        ReflectionTestUtils.setField(controller,"accountService", accountService);
//        when(accountService.updateAccount(account)).thenReturn(new Account());
//        ResponseEntity<?> update = controller.updateAccount(account, account.getAccountId());
//        verify(accountService, times(1)).updateAccount(account);
//        Assert.assertEquals(HttpStatus.CREATED, update.getStatusCode());
//    }
//
//
//}
