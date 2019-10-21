package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    private Bank bank = new Bank();

    @Before
    public void initBank() {
        User user1 = new User("test1", "passport1");
        User user2 = new User("test2", "passport2");
        User user3 = new User("test3", "passport3");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(user3);
        Account account1 = new Account(5, "account1");
        Account account2 = new Account(10, "account2");
        Account account3 = new Account(15, "account3");
        bank.addAccountToUser(user1.getPassport(), account1);
        bank.addAccountToUser(user2.getPassport(), account2);
        bank.addAccountToUser(user3.getPassport(), account3);
    }

    @Test
    public void whenAddUser() {
        User user = new User("userPassport");
        bank.addUser(user);
        List<Account> result = bank.getUserAccounts(user.getPassport());
        List<Account> expect = new ArrayList<>();
        assertThat(result, is(expect));
    }

    @Test
    public void whenNotExistUser() {
        User user = new User("userPassport");
        List<Account> result = bank.getUserAccounts(user.getPassport());
        List<Account> expect = null;
        assertThat(result, is(expect));
    }

    @Test
    public void whenDeleteUser() {
        User user = new User("userPassport");
        bank.addUser(user);
        bank.deleteUser(user);
        List<Account> result = bank.getUserAccounts(user.getPassport());
        List<Account> expect = null;
        assertThat(result, is(expect));
    }

    @Test
    public void whenAddAccountToUser() {
        User user = new User("userPassport");
        bank.addUser(user);
        Account account = new Account(1, "account");
        bank.addAccountToUser(user.getPassport(), account);
        List<Account> accounts = bank.getUserAccounts(user.getPassport());
        boolean result = false;
        for (Account acc : accounts) {
            if (acc.getRequisites().equals(account.getRequisites())) {
                result = true;
                break;
            }
        }
        assertThat(result, is(true));
    }

    @Test
    public void whenNotAddedAccountToUser() {
        User user = new User("userPassport");
        bank.addUser(user);
        Account account = new Account(1, "account");
        List<Account> accounts = bank.getUserAccounts(user.getPassport());
        boolean result = false;
        for (Account acc : accounts) {
            if (acc.getRequisites().equals(account.getRequisites())) {
                result = true;
                break;
            }
        }
        assertThat(result, is(false));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        User user = new User("userPassport");
        bank.addUser(user);
        Account account = new Account(1, "account");
        bank.addAccountToUser(user.getPassport(), account);
        bank.deleteAccountFromUser(user.getPassport(), account);
        List<Account> result = bank.getUserAccounts(user.getPassport());
        List<Account> expect = null;
        assertThat(result, is(expect));
    }

    @Test
    public void whenTransferMoney() {
        boolean result = bank.transferMoney(
                "passport3", "account3",
                "passport1", "account1", 5
        );
        assertThat(result, is(true));
    }

    @Test
    public void whenTransferMoneyNotValue() {
        boolean result = bank.transferMoney(
                "passport3", "account5",
                "passport1", "account1", 5
        );
        assertThat(result, is(false));
    }

    @Test
    public void whenTransferMoneyNotAccount() {
        boolean result = bank.transferMoney(
                "passport3", "account3",
                "passport1", "account1", 20
        );
        assertThat(result, is(false));
    }
}
