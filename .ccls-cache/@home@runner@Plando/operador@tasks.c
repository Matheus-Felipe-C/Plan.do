#include<stdio.h>

void addTask(char name[], FILE *f) {

	if (f == NULL)
	{
	    printf("Error opening file!\n");
	}
	
	/* print text to file.txt */
	fprintf(f, "task_name: %s\n", name);

  //Print a success message
	printf("Task added!");
}

