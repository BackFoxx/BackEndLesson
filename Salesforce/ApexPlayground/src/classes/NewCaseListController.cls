/**
 * Created by PC on 2022-03-05.
 */

public with sharing class NewCaseListController {

    public List<Case> getNewCases() {
        List<Case> caseList = [SELECT CaseNumber FROM Case WHERE Status = 'New'];
        return caseList;
    }

}