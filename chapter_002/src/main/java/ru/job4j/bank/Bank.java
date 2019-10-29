package ru.job4j.bank;

import java.util.*;

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
        List<Account> accounts = this.accounts.get(user);
        return accounts != null ? accounts : new ArrayList<>();
    }

    public boolean transferMoney(
            String srcPassport, String srcRequisite,
            String destPassport, String dstRequisite,
            double amount
    ) {
        boolean result = true;
        List<Account> srcAccounts = getUserAccounts(srcPassport);
        List<Account> destAccounts = getUserAccounts(destPassport);
        Account srcAccount = getAccount(srcAccounts, srcRequisite);
        if (srcAccount == null || (srcAccount.getValue() < amount)) {
            result = false;
        }

        Account dstAccount = getAccount(destAccounts, dstRequisite);
        if (srcAccount == null) {
            result = false;
        }

        if (result) {
            dstAccount.setValue(dstAccount.getValue() + amount);
            srcAccount.setValue(srcAccount.getValue() - amount);
        }
        return result;

    }

    private Account getAccount(List<Account> accounts, String requisite) {
        Account account = null;
        Optional<Account> opt = accounts.stream().filter(acc -> acc.getRequisites().equals(requisite)).findFirst();
        if (opt.isPresent()) {
            account = opt.get();
        }
        return account;
    }

}
