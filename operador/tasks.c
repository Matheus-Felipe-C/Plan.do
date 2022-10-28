#include<stdio.h>

void addTask(char name[]) {
	FILE *f = fopen("file.txt", "w");
	if (f == NULL)
	{
	    printf("Error opening file!\n");
	}
	
	/* print some text */
	fprintf(f, "Some text: %s\n", name);
	
	/* print integers and floats */
	int i = 1;
	float pi= 3.1415927;
	fprintf(f, "Integer: %d, float: %f\n", i, pi);
	
	/* printing single characters */
	char c = 'A';
	fprintf(f, "A character: %c\n", c);
		
	printf("%s", name);
}
