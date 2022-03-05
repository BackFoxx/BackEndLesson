/**
 * Created by PC on 2022-03-04.
 */

public with sharing class TaskUtil {
    public static String getTaskPriority(String leadState) {
        // Validate input
        if (String.isBlank(leadState) || leadState.length() > 2) {
            return null;
        }
        String taskPriority;
        if (leadState == 'CA') {
            taskPriority = 'High';
        } else {
            taskPriority = 'Normal';
        }
        return taskPriority;
    }
}