/**
 * Created by PC on 2022-03-06.
 */

@IsTest
private class DailyLeadProcessorTest {
    @TestSetup
    static void testSetup() {
        List<Lead> leads = new List<Lead>();
        for (Integer i=0; i<200; ++i) {
            leads.add(new Lead(Company='apple', LastName = 'test '+i));
        }
        insert leads;
    }
    @IsTest
    static void testBehavior() {
        DailyLeadProcessor dailyLeadProcessor = new DailyLeadProcessor();
        String CRON_EXP = '0 0 0 10 2 ?';

        Test.startTest();
        System.schedule('dailyLeadProcessor', CRON_EXP, dailyLeadProcessor);
        Test.stopTest();

        Integer i = [SELECT COUNT() FROM Lead WHERE LeadSource = 'Dreamforce'];
        System.assertEquals(200, i);
    }
}