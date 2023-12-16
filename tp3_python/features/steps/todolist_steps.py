from behave import *
from todolist import TodoList, TaskInvalidFormat


todoList = TodoList
task = ""
taskAdded = False


@given('la liste de tâches à faire')
def setTodoList(context):
    global todoList
    todoList = TodoList([
        'Préparer prés. (MM, 18/12)',
        'RÉVISER contrôle (NewDB, 19/12)',
        'RÉVISER contrôle (Management, 20/12)'
    ])

@given('le format à respecter')
def setTaskFormat(context):
    todoList.setTaskFormat("^.*\S*\s\(.*\S*,\s{0,1}\d{1,2}\/\d{1,2}\)$")

@given('la tâche "{t}"')
def setNewTask(context, t):
    global task
    task = t

@when('la tâche est ajoutée à la liste')
def addNewTask(context):
    global taskAdded
    try:
        todoList.addTask(task)
        taskAdded = True
    except TaskInvalidFormat:
        taskAdded = False

@then('la liste est mise à jour sans erreur')
def checkTodoList(context):
    assert taskAdded
    assert isTaskInTodoList()

@then('une erreur est renvoyée')
def checkError(context):
    assert not taskAdded
    assert not isTaskInTodoList()


def isTaskInTodoList():
    for t in todoList.getTasks():
        if t == task: return True
    return False