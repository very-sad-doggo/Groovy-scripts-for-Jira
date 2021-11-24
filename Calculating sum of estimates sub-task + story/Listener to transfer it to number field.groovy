import com.atlassian.jira.issue.Issue
import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.ModifiedValue
import com.atlassian.jira.issue.util.DefaultIssueChangeHolder

def customFieldManager = ComponentAccessor.customFieldManager

def IssueManager = ComponentAccessor.getIssueManager()

def issue = event.getIssue();

def cField = customFieldManager.getCustomFieldObject("calculatedfield_id");

def cFieldValue = issue.getCustomFieldValue(cField);

def targetField = customFieldManager.getCustomFieldObjects(issue).findByName("Target Numeric Field value");

def newValue = cFieldValue;

targetField.updateValue(null, issue, new ModifiedValue(issue.getCustomFieldValue(cField), newValue), new DefaultIssueChangeHolder())