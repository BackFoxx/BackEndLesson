/**
 * Created by PC on 2022-03-06.
 */

public with sharing class AddPrimaryContact implements Queueable{
    private Contact contact;
    private String stateAbbreviation;

    public AddPrimaryContact(Contact contact, String stateAbbreviation) {
        this.contact = contact;
        this.stateAbbreviation = stateAbbreviation;
    }

    public void execute(QueueableContext param1) {
        List<Account> accounts = [SELECT Id FROM Account WHERE BillingState = :stateAbbreviation LIMIT 200];
        List<Contact> contacts = new List<Contact>();
        for (Account a: accounts) {
            Contact contactClone = contact.clone();
            contactClone.AccountId = a.Id;
            contacts.add(contactClone);
        }
        insert contacts;
    }
}