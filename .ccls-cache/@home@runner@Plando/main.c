#include <stdio.h>
#include "./operador/tasks.h"

int main(void) {
  char test[] = "I got a gun, bitch!";
  //Opens file.txt to add the task to it, or creates the file if it's deleted
  FILE *f = fopen("file.txt", "a");

  //Calls function that adds a task name to file.txt
  addTask(test, f);
  return 0;
}