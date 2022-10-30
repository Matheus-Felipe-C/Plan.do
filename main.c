#include <stdio.h>
#include "./operador/tasks.h"

int main(void) {
  char test[] = "Show me";
  //Opens file.txt to add the task to it, or creates the file if it's deleted

  //Calls function that adds a task name to file.txt
  addTask(test);
  //Calls function that shows the task list
  showTaskList();
  return 0;
}