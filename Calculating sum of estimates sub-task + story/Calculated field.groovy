import com.atlassian.jira.issue.Issue

//default estimates sum = 0
long totalSum = 0;
boolean noEstimates = true;
//number of subtasks
def totalSubTasks = issue.getSubTaskObjects().size()

//If subtask estimate is not 0 add the value to totalSum
//In the end divide totalSum to 3600 to get value in hours
for(Issue subtask: issue.getSubTaskObjects()){
 if(subtask.getEstimate() != null){
 totalSum += subtask.getEstimate()
 noEstimates = false
 }
}
if (issue.getEstimate() != null){
 totalSum += issue.getEstimate()
 noEstimates = false
} 

if (noEstimates == true){
 return null
}
else {
 return totalSum / 3600
}