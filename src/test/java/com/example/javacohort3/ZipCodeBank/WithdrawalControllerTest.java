package com.example.javacohort3.ZipCodeBank;

import com.example.javacohort3.ZipCodeBank.controllers.DepositController;
import com.example.javacohort3.ZipCodeBank.controllers.WithdrawalController;
import com.example.javacohort3.ZipCodeBank.domains.Account;
import com.example.javacohort3.ZipCodeBank.domains.Deposit;
import com.example.javacohort3.ZipCodeBank.domains.Withdrawal;
import com.example.javacohort3.ZipCodeBank.services.DepositService;
import com.example.javacohort3.ZipCodeBank.services.WithdrawalService;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@WebAppConfiguration
public class WithdrawalControllerTest {
    @Mock
    private WithdrawalService withdrawalService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getAllWithdrawalForAccountIdTest() {
        WithdrawalController controller = new WithdrawalController();
        ReflectionTestUtils.setField(controller, "withdrawalService",withdrawalService);
        Account account = new Account();
        Long accountId = account.getId();

        when(withdrawalService.getWithdrawalsByAccountId(accountId)).thenReturn(new ArrayList<>());
        ResponseEntity<?> depositsReturned = controller.getWithdrawalsByAccountId(accountId);
        verify(withdrawalService, times(1)).getWithdrawalsByAccountId(accountId);
        Assert.assertEquals(HttpStatus.OK, depositsReturned.getStatusCode());
    }

    @Test
    public void getDepositByIdTest() {
        WithdrawalController controller = new WithdrawalController();
        ReflectionTestUtils.setField(controller, "withdrawalService", withdrawalService);
        Withdrawal withdrawal = new Withdrawal();
        Long id = withdrawal.getId();

        when(withdrawalService.getWithdrawalById(id)).thenReturn(withdrawal);
        ResponseEntity<?> depositReturned = controller.getWithdrawlById(id);
        verify(withdrawalService, times(1)).getWithdrawalById(id);
        Assert.assertEquals(HttpStatus.OK, depositReturned.getStatusCode());
    }

    @Test
    public void createDepositFromAccountIdTest() {
        WithdrawalController controller = new WithdrawalController();
        ReflectionTestUtils.setField(controller, "withdrawalService", withdrawalService);
        Account account = new Account();
        Withdrawal withdrawal = new Withdrawal();
        Long accountId = account.getId();

        when(withdrawalService.createWithdrawal(withdrawal)).thenReturn(withdrawal);
        ResponseEntity<?> withdrawalCreated = controller.createWithdrawlByAccountId(withdrawal,accountId);
        verify(withdrawalService, times(1)).createWithdrawal(withdrawal);
        Assert.assertEquals(HttpStatus.CREATED, withdrawalCreated.getStatusCode());
    }

    @Test
    public void updateDepositTest() {
        WithdrawalController controller = new WithdrawalController();
        ReflectionTestUtils.setField(controller, "withdrawalService", withdrawalService);
        Withdrawal withdrawal = new Withdrawal();
        Long id = withdrawal.getId();



        when(withdrawalService.updateWithdrawal(withdrawal)).thenReturn(withdrawal);
        ResponseEntity<?> withdrawlUpdated = controller.updateWithdrawl(id,withdrawal);
        verify(withdrawalService, times(1)).updateWithdrawal(withdrawal);
        Assert.assertEquals(HttpStatus.OK, withdrawlUpdated.getStatusCode());
    }

    @Test
    public void deleteDepositByIdTest() {
        WithdrawalController controller = new WithdrawalController();
        ReflectionTestUtils.setField(controller, "withdrawalService", withdrawalService);

        Withdrawal withdrawal = new Withdrawal();
        Long id = withdrawal.getId();
        withdrawalService.deleteWithdrawalById(id);
        when(withdrawalService.getWithdrawalById(id)).thenReturn(null);
        ResponseEntity<?> withdrawalDeleted = controller.deleteWithdrawal(id);
        verify(withdrawalService, times(2)).deleteWithdrawalById(id);
        Assert.assertEquals(HttpStatus.NO_CONTENT, withdrawalDeleted.getStatusCode());
    }
}
