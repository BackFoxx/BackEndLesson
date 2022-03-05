/**
 * Created by PC on 2022-03-04.
 */

@IsTest
private class TestRestrictContactByName {
    @IsTest
    static void insertError() {
        Test.startTest();
        Contact c = new Contact(LastName = 'INVALIDNAME');
        Database.SaveResult result = Database.insert(c, false);
        Test.stopTest();

        System.assert(!result.isSuccess());
        System.assert(result.getErrors().size() > 0);
        System.assertEquals('The Last Name "INVALIDNAME" is not allowed for DML', result.getErrors()[0].getMessage());
    }

    @IsTest
    static void insertPass() {
        Test.startTest();
        Contact c = new Contact(LastName = 'VALIDNAME');
        Database.SaveResult result = Database.insert(c, false);
        Test.stopTest();

        System.assert(result.isSuccess());
    }

    @IsTest
    static void updateError() {
        Test.startTest();
        Contact c = new Contact(LastName = 'VALIDNAME');
        insert c;

        c.LastName = 'INVALIDNAME';
        Database.SaveResult result = Database.update(c, false);
        Test.stopTest();

        System.assert(!result.isSuccess());
        System.assert(result.getErrors().size() > 0);
        System.assertEquals('The Last Name "INVALIDNAME" is not allowed for DML', result.getErrors()[0].getMessage());
    }

    @IsTest
    static void updatePass() {
        Test.startTest();
        Contact c = new Contact(LastName = 'VALIDNAME');
        insert c;

        c.LastName = 'ANOTHERVALIDNAME';
        Database.SaveResult result = Database.update(c, false);
        Test.stopTest();

        System.assert(result.isSuccess());
    }
}