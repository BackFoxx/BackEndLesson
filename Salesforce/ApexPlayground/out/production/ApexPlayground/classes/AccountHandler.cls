/**
 * Created by PC on 2022-03-03.
 */

public with sharing class AccountHandler {
 public static Account insertNewAccount(String accountName) {
     try {
         Account account = new Account(Name = accountName);
         insert account;
         return account;
     } catch (DmlException e) {
         return null;
     }
 }
}