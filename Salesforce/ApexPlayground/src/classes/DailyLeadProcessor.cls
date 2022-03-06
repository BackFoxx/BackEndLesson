/**
 * Created by PC on 2022-03-06.
 */

public with sharing class DailyLeadProcessor implements Schedulable{

    List<Lead> leads = [SELECT Id FROM Lead WHERE LeadSource = '' LIMIT 200];

    public void execute(SchedulableContext param1) {
        for (Lead l : leads) {
            l.LeadSource = 'Dreamforce';
        }
        update leads;
    }
}