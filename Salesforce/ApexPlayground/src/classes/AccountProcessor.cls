/**
 * Created by PC on 2022-03-05.
 */

public with sharing class AccountProcessor {
    @Future(Callout = true)
    public static void countContacts(List<Id> idList) {
        List<Account> accounts = [SELECT Id, (SELECT Id from Contacts) FROM Account WHERE Id IN :idList];
        for (Account a : accounts) {
            a.Number_Of_Contacts__c = a.Contacts.size();
        }
        update accounts;
    }
}