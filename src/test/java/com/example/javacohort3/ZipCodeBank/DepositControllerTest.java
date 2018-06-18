package com.example.javacohort3.ZipCodeBank;

import com.example.javacohort3.ZipCodeBank.controllers.DepositController;
import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.services.DepositService;
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

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class DepositControllerTest {
    @Mock
    private DepositService depositService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllDepositsForAccountIdTest() {
        DepositController controller = new DepositController();
        ReflectionTestUtils.setField(controller, "depositService", depositService);

        Account account = new Account();
        Deposit deposit = new Deposit();
        account.setId(new Long(3));
        Long accountId = account.getId();
        deposit.setAccount_id(accountId);

        depositService.createDepositByFromAccountId(deposit, accountId);
        when(depositService.getAllDepositsForAccountId(accountId).get(0)).thenReturn(deposit);
        ResponseEntity<?> depositsReturned = controller.getAllDepositsForAccountId(accountId);
        verify(depositService, times(1)).getAllDepositsForAccountId(accountId);
        Assert.assertEquals(HttpStatus.OK, depositsReturned.getStatusCode());
    }

    @Test
    public void getDepositByIdTest() {
        DepositController controller = new DepositController();
        ReflectionTestUtils.setField(controller, "depositService", depositService);

        Deposit deposit = new Deposit();
        deposit.setId(new Long(5));
        Long id = deposit.getId();

        when(depositService.getDepositById(id)).thenReturn(deposit);
        ResponseEntity<?> depositReturned = controller.getDepositById(id);
        verify(depositService, times(1)).getDepositById(id);
        Assert.assertEquals(HttpStatus.OK, depositReturned.getStatusCode());
    }

    @Test
    public void createDepositFromAccountIdTest() {
        DepositController controller = new DepositController();
        ReflectionTestUtils.setField(controller, "depositService", depositService);

        Account account = new Account();
        Deposit deposit = new Deposit();
        account.setId(new Long(3));
        Long accountId = account.getId();
        deposit.setAccount_id(accountId);

        when(depositService.createDepositByFromAccountId(deposit, accountId)).thenReturn(deposit);
        ResponseEntity<?> depositCreated = controller.createDepositFromAccountId(deposit, accountId);
        verify(depositService, times(1)).getAllDepositsForAccountId(accountId);
        Assert.assertEquals(HttpStatus.CREATED, depositCreated.getStatusCode());
    }

    @Test
    public void updateDepositTest() {
        DepositController controller = new DepositController();
        ReflectionTestUtils.setField(controller, "depositService", depositService);

        Deposit deposit = new Deposit();
        deposit.setId(new Long(5));
        Long id = deposit.getId();

        when(depositService.updateDeposit(deposit)).thenReturn(deposit);
        ResponseEntity<?> depositCreated = controller.updateDeposit(deposit, id);
        verify(depositService, times(1)).getDepositById(id);
        Assert.assertEquals(HttpStatus.OK, depositCreated.getStatusCode());
    }

    @Test
    public void deleteDepositByIdTest() {
        DepositController controller = new DepositController();
        ReflectionTestUtils.setField(controller, "depositService", depositService);

        Deposit deposit = new Deposit();
        deposit.setId(new Long(5));
        Long id = deposit.getId();

        depositService.deleteDeposit(id);
        when(depositService.getDepositById(id)).thenReturn(null);
        ResponseEntity<?> depositDeleted = controller.deleteDepositById(id);
        verify(depositService, times(2)).deleteDeposit(id);
        Assert.assertEquals(HttpStatus.NO_CONTENT, depositDeleted.getStatusCode());
    }
}
