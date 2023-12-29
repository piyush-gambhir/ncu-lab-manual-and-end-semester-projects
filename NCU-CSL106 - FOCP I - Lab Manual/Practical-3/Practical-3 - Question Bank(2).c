#include <stdio.h>
int main()
{
    int i = 1, salary, count, max_sal, min_sal;
    printf("Enter Number of Employees: ");
    scanf("%d", &count);
    printf("Enter Salary of Employee Number %d: ", i);
    scanf("%d", &salary);
    max_sal = min_sal = salary;
    for (i = 2; i <= count; i++){
        printf("Enter Salary of Employee Number %d: ", i);
        scanf("%d", &salary);
        if (salary > max_sal){
            max_sal = salary;
        }
        else if (salary < min_sal){
            min_sal = salary;
        }
        else{
            continue;
        }
    }   
    printf("\nMax Salary: %d", max_sal);
    printf("\nMin Salary: %d", min_sal);
}