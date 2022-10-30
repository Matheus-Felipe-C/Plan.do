#include<stdio.h>

void addTask(char name[]) {

  FILE *f = fopen("file.txt", "a+");

	if (f == NULL)
	{
	    printf("Error opening file!\n");
	}
	
	/* print text to file.txt */
	fprintf(f, "task_name: %s\n\n", name);

  //Print a success message
	printf("Task added!\n");

  /* Closing out the file at the end of every function is necessary for
    showTaskList function to work properly
  */
  fclose(f);
}

void showTaskList() {
  //Apparently, if you declare the file here it works, but doesn't if it's sent as a parameter...
  FILE *f = fopen("file.txt", "a+");
  //Character that is going to be read from file.txt
  char ch;

  if (NULL == f) {
        printf("file can't be opened \n");
    }

  while (!feof(f)) {
        ch = fgetc(f);
        printf("%c", ch);
    }
  fclose(f);
}