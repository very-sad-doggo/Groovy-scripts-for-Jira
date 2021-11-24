import com.atlassian.jira.bc.user.UserService
import com.atlassian.jira.component.ComponentAccessor
import org.apache.log4j.Logger


/* CSV FORMAT
user1; user1@example.com; John Doe; 
user2; user@example.com; Pasha Technician*/

File file = new File("/disk/jira_home/sample_uploads/users.csv")
def csvMapList = []

file.eachLine { line ->
def columns = line.split(";")
def tmpMap = [:]

tmpMap.putAt("username", columns[0])
tmpMap.putAt("email", columns[1])
tmpMap.putAt("displayName", columns[2])
csvMapList.add(tmpMap)
}

//return csvMapList


// notifications are sent by default, set to false to not send a notification
final boolean sendNotification = false

final String password = "password"

def log = Logger.getLogger("com.onresolve.scriptrunner.runner.ScriptRunnerImpl")

def loggedInUser = ComponentAccessor.jiraAuthenticationContext.loggedInUser
def userService = ComponentAccessor.getComponent(UserService)

csvMapList.each{ tmpMap -> 
    log.warn("Creating user ${tmpMap.getAt("username")} with email address ${tmpMap.getAt("email")} and displayname ${tmpMap.getAt("displayName")} ")
    
def newCreateRequest = UserService.CreateUserRequest.withUserDetails(loggedInUser, tmpMap.getAt("username").toString(), password, tmpMap.getAt("email").toString(), 
                                                                     tmpMap.getAt("displayName").toString()).sendNotification(sendNotification)

def createValidationResult = userService.validateCreateUser(newCreateRequest)
assert createValidationResult.valid : createValidationResult.errorCollection

userService.createUser(createValidationResult)
} 