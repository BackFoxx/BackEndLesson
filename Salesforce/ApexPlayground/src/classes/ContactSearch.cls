/**
 * Created by PC on 2022-03-03.
 */

public with sharing class ContactSearch {
    public static List<Contact> searchForContacts(String lastName, String mailingPostalCode) {
        List<Contact> foundList = [SELECT Id, Name FROM Contact WHERE LastName = :lastName AND MailingPostalCode = :mailingPostalCode];
        return foundList;
    }
}