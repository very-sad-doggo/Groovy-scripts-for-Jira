// Initializer 

import com.atlassian.jira.issue.resolution.Resolution

def resolutionField = getFieldById("resolution")
def customfield = getFieldById("customfield_someid")

   customfield.setHidden(true)

//Script

import com.atlassian.jira.issue.resolution.Resolution

def resolutionField = getFieldById("resolution")
//define your target custom field
def customfield = getFieldById("customfield_someid")

def resolution = resolutionField.getValue() as Resolution

if (resolution.name == "Done") {
    customfield.setRequired(true)
   customfield.setHidden(false)
}
else {
    customfield.setHidden(true)
    customfield.setRequired(false)
}