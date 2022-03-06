/**
 * Created by PC on 2022-03-05.
 */

@IsTest
private class LeadProcessorTest {
    @TestSetup
    static void testBehavior() {
        List<Lead> leadLists = new List<Lead>();
        for (Integer i=0; i<200; ++i) {
            leadLists.add(new Lead(Company = 'apple', LastName = 'test '+i, LeadSource = 'Test '+i));
        }
        insert leadLists;
    }

    @IsTest
    static void test() {
        Test.startTest();
        LeadProcessor processor = new LeadProcessor();
        Database.executeBatch(processor);
        Test.stopTest();
        System.assertEquals(200, [SELECT COUNT() FROM Lead WHERE LeadSource = 'Dreamforce']);
    }
}