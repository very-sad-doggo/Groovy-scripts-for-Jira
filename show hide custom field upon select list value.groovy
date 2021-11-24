// Initializer


def field1 = getFieldById("customfield_14262") 
def field2 = getFieldById("customfield_14263") 


field1.setHidden(true)
field2.setHidden(true)


//Script

import com.onresolve.jira.groovy.user.FieldBehaviours
import org.apache.log4j.Logger
import org.apache.log4j.Level
import groovy.transform.BaseScript

@BaseScript FieldBehaviours fieldBehaviours
def log = Logger.getLogger(getClass())

// Set log level
log.setLevel(Level.DEBUG)

//DEFINING TARGET FIELDS

def field1 = getFieldById("customfield_14262") 
def field2 = getFieldById("customfield_14263") 

//Select list and its value
def seleclistfield = getFieldByName("Select List Name")
def seleclistfield = seleclistfield.value as List

if (seleclistfield == ["Groovy Script"]) {
field1.setHidden(false)
field2.setHidden(false)
 
}
else {
    field1.setHidden(true)
    field2.setHidden(true)
}