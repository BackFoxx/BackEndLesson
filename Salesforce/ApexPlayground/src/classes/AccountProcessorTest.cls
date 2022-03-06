/**
 * Created by PC on 2022-03-05.
 */

@IsTest
private class AccountProcessorTest {
    @IsTest
    static void testBehavior() {
        List<Account> listAccounts = new List<Account>();
        for (Integer i=0; i<300; ++i) {
            listAccounts.add(new Account(Name='Test Account '+i));
        }
        insert listAccounts;
        //
        List<Contact> contacts = new List<Contact>();
        List<Id> accountIds = new List<Id>();
        for (Account a : listAccounts) {
            contacts.add(new Contact(FirstName=a.Name, LastName='testContext', AccountId=a.Id));
            accountIds.add(a.Id);
        }
        insert contacts;

        //

        Test.startTest();
        AccountProcessor.countContacts(accountIds);
        Test.stopTest();

        //

        List<Account> results = [SELECT Id, Number_Of_Contacts__c FROM Account];
        for (Account a : results) {
            System.assertEquals(1, a.Number_Of_Contacts__c);
        }
    }
}