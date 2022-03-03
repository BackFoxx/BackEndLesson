/**
 * Created by PC on 2022-03-03.
 */

public with sharing class ContactAndLeadSearch {
    public static List<List<SObject>> searchContactsAndLeads(String anyName) {
        List<List<SObject>> found = [FIND :anyName in ALL FIELDS RETURNING Contact, Lead];
        System.debug(found);
        return found;
    }
}