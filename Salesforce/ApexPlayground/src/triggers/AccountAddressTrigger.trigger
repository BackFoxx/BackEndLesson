/**
 * Created by PC on 2022-03-03.
 */

trigger AccountAddressTrigger on Account (before insert, before update) {
    for(Account a : Trigger.new){
        if(a.Match_Billing_Address__c){
            a.ShippingPostalCode = a.BillingPostalCode;
        }
    }
}