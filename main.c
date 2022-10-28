#include<stdio.h>
#include "tasks.h"
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char** argv) {
	char taskName[90];
	
	printf("Digite o nome da task:\n");
	fgets(taskName, 90, stdin);
	
	addTask(taskName);	
	return 0;
}
