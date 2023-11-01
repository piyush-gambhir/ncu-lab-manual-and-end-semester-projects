#include<stdio.h>

int main(){
	
	int marks_1, marks_2, marks_3, marks_4, marks_5, total_marks;
	float percentage;
	
	printf("Enter the Marks in Subject 1: ");
	scanf("%d", &marks_1);
	printf("Enter the Marks in Subject 2: ");
	scanf("%d", &marks_2);
	printf("Enter the Marks in Subject 3: ");
	scanf("%d", &marks_3);
	printf("Enter the Marks in Subject 4: ");
	scanf("%d", &marks_4);
	printf("Enter the Marks in Subject 5: ");
	scanf("%d", &marks_5);
	
	total_marks = marks_1 + marks_2 + marks_3 + marks_4 + marks_5;
	percentage = ((total_marks/5));
	
	printf("\nTotal Marks: %d", total_marks);
	printf("\nPercentage Obtained: %2f", percentage);
	
	if (percentage>60){
		printf("\nPassed in First Division");
		}
	else if (percentage>50 && percentage<59){
		printf("\nPassed in Second Division");
	}
	else if (percentage>40 && percentage<49){
		printf("\nPassed in Third Division");
	}
	else{
		printf("\nFail");
	}
	return 0;
}




