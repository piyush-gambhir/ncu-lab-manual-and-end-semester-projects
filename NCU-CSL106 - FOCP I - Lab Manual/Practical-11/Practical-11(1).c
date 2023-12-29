#include <stdio.h>

void main()
{
    struct employee_details
    {
        char name[50];
        int salary;
        float work_hours;
    };
    
    int i = 10;
    struct employee_details emp[i];
    for (int i = 1; i <= 10; i++)
    {
        printf("Enter the Name of the Employee %d: ", i);
        scanf("%s", &emp[i].name);
        printf("Enter the Salary of the Employee %d: ", i);
        scanf("%s", &emp[i].salary);
        printf("Enter the Work Hours of the Employee %d: ", i);
        scanf("%s", &emp[i].work_hours);
        printf("\n");\
    }
    for (int i = 1; i <= 10; i++)
    {
        printf("Name: %c   |   Salary: %d", emp[i].name, emp[i].salary);
        printf("\n");
    }
}





