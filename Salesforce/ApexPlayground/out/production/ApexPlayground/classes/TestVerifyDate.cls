/**
 * Created by PC on 2022-03-04.
 */

@IsTest
private class TestVerifyDate {
    @IsTest
    static void false_false() {
        Date date1 = Date.today(); //2022-03-04
        Date date2 = date1.addDays(15); //2022-03-19
        Date assertDate = Date.newInstance(2022,03,31);
        System.assertEquals(assertDate, VerifyDate.CheckDates(date2,date1));
    }

    @IsTest
    static void false_false2() {
        Date date1 = Date.today(); //2022-03-04
        Date date2 = date1.addMonths(3); //2022-03-19
        Date assertDate = Date.newInstance(2022,03,31);
        System.assertEquals(assertDate, VerifyDate.CheckDates(date1,date2));
    }

    @IsTest
    static void true_false() {
        Date date1 = Date.today(); //2022-03-04
        Date date2 = date1.addDays(15); //2022-03-19
        System.assertEquals(date2, VerifyDate.CheckDates(date1,date2));
    }
}