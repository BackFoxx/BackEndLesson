/**
 * Created by PC on 2022-03-03.
 */

trigger ClosedOpportunityTrigger on Opportunity (after insert, after update) {

    List<Task> taskList = new List<Task>();
    for (Opportunity o : Trigger.new) {
        if (o.StageName == 'Closed Won') {
            Task task = new Task();
            task.Subject = 'Follow Up Test Task';
            task.WhatId = o.Id;
            taskList.add(task);
        }
    }
    insert taskList;
}