import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.issue.Issue

def cfManager = ComponentAccessor.customFieldManager

//defining numeric assets

def numfield1 = 0
def numfield2 = 0
def numtfield3 = 0

//getting values as list

def field1Value = issue.getCustomFieldValue(field1) as List
def field2Value = issue.getCustomFieldValue(field2) as List
def field3Value = issue.getCustomFieldValue(field2) as List
def numfieldValue = issue.getCustomFieldValue(numfield) as int

// Mapping options with numbers
switch (field1Value)
{
    case 'option1':
    numfield1 = 0.8
        break
    case 'option2':
    numfield1 = 1
        break
    case 'option 2 + 3':
    numfield1 = 1.25
        break
    default:
        numfield1 = 0
}
switch (field2Value)
{
    case 'option1':
    numfield2 = 1
        break
    case 'Makeup II':
    numfield2 = 0.8
        break
    case 'option2':
    numfield2 = 1
        break
    case 'option3':
    numfield2 = 1
        break
    case 'option4':
    numfield2 = 1
        break
    default:
        numfield2 = 0
}
switch (field3Value)
{
    case 'option x':
    numfield3 = 1
        break
    case 'option y':
    numfield3 = 1.2
        break
    case 'option z':
    numfield3 = 1.5
        break
    default:
        numfield3 = 0
}

//multiplication

def mult = numfield1 * numfield2 * numfield3 * numfieldValue
if (mult != 0) {
    return mult
}
else {
    return 0
}
