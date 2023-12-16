import re


class TaskInvalidFormat(Exception):
    def __init__(self, task):
        super(TaskInvalidFormat, self).__init__(f'The given task "{task}" doesn\'t check the set format.')


class TodoList:

    def __init__(self, taskFormat="", tasks=None):
        self.__tasks = tasks if tasks else []
        self.__taskFormat = taskFormat

    def setTaskFormat(self, taskFormat):
        self.__taskFormat = taskFormat

    def __isTaskFormatValid(self, task):
        if re.search(self.__taskFormat, task): return True
        else: raise TaskInvalidFormat(task)

    def addTask(self, task):
        if self.__isTaskFormatValid(task): self.__tasks.append(task)

    def setTask(self, index, task):
        if self.__isTaskFormatValid(task): self.__tasks[index] = task

    def removeTask(self, index):
        del self.__tasks[index]

    def getTasks(self):
        return self.__tasks