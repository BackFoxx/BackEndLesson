/**
 * Created by PC on 2022-03-06.
 */

@IsTest
private class AddPrimaryContactTest {
    @TestSetup
    static void testSetup() {
        List<Account> accounts = new List<Account>();
        for (Integer i=0; i<50; ++i) {
            accounts.add(new Account(Name = 'testNY '+i, BillingState = 'NY'));
            accounts.add(new Account(Name = 'testCA '+i, BillingState = 'CA'));
        }
        insert accounts;
    }
    static testMethod void test() {
        Contact contact = new Contact(LastName = 'poop');
        insert contact;

        AddPrimaryContact addPrimaryContact = new AddPrimaryContact(contact, 'CA');
        Test.startTest();
        System.enqueueJob(addPrimaryContact);
        Test.stopTest();

        System.assertEquals(50, [SELECT COUNT() from Contact WHERE Contact.Account.BillingState = 'CA']);
        System.assertEquals(0, [SELECT COUNT() from Contact WHERE Contact.Account.BillingState = 'NY']);
    }
}