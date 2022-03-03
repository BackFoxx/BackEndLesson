/**
 * Created by PC on 2022-03-03.
 */

trigger AccountDeletion on Account (before delete) {
    for (Account a : [SELECT Id FROM Account
    WHERE Id IN (SELECT AccountId FROM Opportunity) AND
    Id IN :Trigger.old]) {
        Trigger.oldMap.get(a.Id).addError(
                'Cannot delete account with related opportunities.');
    }
}