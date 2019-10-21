package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<User, List<Account>> accounts = new HashMap<>();

    public void addUser(User user) {
        accounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        accounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (accounts != null) {
            accounts.add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = new User(passport);
        accounts.remove(user);
    }

    public List<Account> getUserAccounts(String passport) {
        User user = new User(passport);
        return this.accounts.get(user);
    }

    public boolean transferMoney (
            String srcPassport, String srcRequisite,
            String destPassport, String dstRequisite,
            double amount
    ) {
        boolean result = true;
        List<Account> srcAccounts = getUserAccounts(srcPassport);
        if (srcAccounts == null) {
            result = false;
        }
        List<Account> destAccounts = getUserAccounts(destPassport);
        if (destAccounts == null) {
            result = false;
        }
        if (result) {
            Account srcAccount = getAccount(srcAccounts, srcRequisite);
            if (srcAccount == null || (srcAccount.getValue() < amount)) {
                result = false;
            }

            Account dstAccount = getAccount(destAccounts, dstRequisite);
            if (dstAccount == null) {
                result = false;
            }

            if (result) {
                dstAccount.setValue(dstAccount.getValue() + amount);
                srcAccount.setValue(srcAccount.getValue() - amount);
            }
        }
        return result;

    }

    private Account getAccount(List<Account> accounts, String requisite) {
        Account account = null;
        for (Account acc : accounts) {
            if (acc.getRequisites().equals(requisite)) {
                account = acc;
                break;
            }
        }
        return account;
    }

}
