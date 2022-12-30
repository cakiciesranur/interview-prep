import testDomePractices.Account;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void depositDoneSuccessfully() {
        Account account = new Account(30.0);
        Assert.assertTrue(account.deposit(20.0));
    }

    @Test
    public void withdrawFailed() {
        Account account = new Account(10.0);
        Assert.assertFalse(account.withdraw(20.0));
    }

    @Test
    public void withdrawDoneSuccessfully() {
        Account account = new Account(30.0);
        Assert.assertTrue(account.withdraw(20.0));
    }

    @Test
    public void depositAndWithdrawRespectively() {
        Account account = new Account(30.0);
        account.deposit(20.0);
        account.withdraw(5.0);
        Assert.assertEquals(15.0, account.getBalance(), epsilon);
    }

    @Test
    public void withdrawNotAcceptNegativeAmount() {
        Account account = new Account(30.0);
        Assert.assertFalse(account.withdraw(-20));
    }

    @Test
    public void depositNotAcceptNegativeAmount() {
        Account account = new Account(30.0);
        Assert.assertFalse(account.deposit(-20));
    }
}
