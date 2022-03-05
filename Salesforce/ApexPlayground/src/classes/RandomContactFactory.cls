/**
 * Created by PC on 2022-03-04.
 */

public with sharing class RandomContactFactory {
    public static List<Contact> generateRandomContacts(Integer numberOfContants, String lastName) {
        List<Contact> lists = new List<Contact>();
        for (Integer i=0; i<numberOfContants; ++i) {
            Contact contact = new Contact(FirstName = 'Test '+ i, LastName=lastName);
            lists.add(contact);
        }
        insert lists;
        return lists;
    }
}