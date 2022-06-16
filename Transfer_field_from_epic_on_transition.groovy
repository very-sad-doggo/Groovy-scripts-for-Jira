import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue
import com.atlassian.jira.issue.MutableIssue

def customFieldManager = ComponentAccessor.getCustomFieldManager()
def issue = issue as MutableIssue


["Field1", "Field2", "Field3"].each { cfname ->
 def cf = customFieldManager.getCustomFieldObjects(issue).find {it.name == cfname}
 def epicCf = customFieldManager.getCustomFieldObjects(issue).find {it.name == 'Epic Link'}
 if (!cf || !epicCf) {return}
 
 def epic = issue.getCustomFieldValue(epicCf) as Issue
 if (!epic) {return}
 
 def cfValue = cf.getValue(epic)
 
 issue.setCustomFieldValue(cf, cfValue)
}