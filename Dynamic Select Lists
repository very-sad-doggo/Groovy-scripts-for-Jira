import com.atlassian.jira.component.ComponentAccessor
import com.onresolve.jira.groovy.user.FieldBehaviours
import groovy.transform.BaseScript

@BaseScript FieldBehaviours fieldBehaviours

final singleSelectName = 'Source field'
final selectName = 'Dynamic Field'

def cfManager = ComponentAccessor.customFieldManager
def optionsManager = ComponentAccessor.optionsManager

def singleSelectField = cfManager.getCustomFieldObjectsByName(selectName)[0]
def formSingleSelect = getFieldByName(singleSelectName)
def singleSelectValue = formSingleSelect?.value
def formSelect = getFieldByName(selectName)

// Make sure the fields we want to work with are on the form
if (!formSingleSelect && !formSelect) {
    return
}

// Must grab the relevant config given the current issue context and the custom field
def config = ComponentAccessor.fieldConfigSchemeManager.getRelevantConfig(issueContext, singleSelectField)
// Given config, grab a map of the possible options for the second select custom field
def options = optionsManager.getOptions(config)

// Define your preset options for each single select case using the format shown here.
// Just put the values, not the keys/IDs.
def optionSet1 = [
    'Option A'
]
def optionSet2 = [
    'Option B',
    'Option C'
]
def optionSet3 = [
    'Option D'
]

// Make sure the second field actually has options to set
if (!options) {
    return
}
// Set/use the appropriate optionSet, dependent on the value of the currently selected single select option
switch (singleSelectValue) {
// Notice: The optionSet that is used is changed in each case
// Change 'Single Select Option...' to match your single select's values.
    case 'Single Select Option1':
        formSelect.setFieldOptions(options.findAll { it.value in optionSet1 }.collectEntries {
            [(it.optionId): it.value]
        })
        break
    case 'Single Select Option2':
        formSelect.setFieldOptions(options.findAll { it.value in optionSet2 }.collectEntries {
            [(it.optionId): it.value]
        })
        break
    case 'Single Select Option3':
        formSelect.setFieldOptions(options.findAll { it.value in optionSet1 }.collectEntries {
            [(it.optionId): it.value]
        })
        break
    
// Reset to default options if single select option is null or any other option that is not taken care of
    default:
        formSelect.setFieldOptions(options)
}