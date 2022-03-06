/**
 * Created by PC on 2022-03-05.
 */

public with sharing class LeadProcessor implements Database.Batchable<sObject> {

    public Database.QueryLocator start(Database.BatchableContext param1) {
        return Database.getQueryLocator([SELECT id, name FROM Lead]);
    }

    public void execute(Database.BatchableContext param1, List<Lead> leads) {
        for (Lead l : leads) {
            l.LeadSource = 'Dreamforce';
        }
        update leads;
    }

    public void finish(Database.BatchableContext param1) {
    }

}