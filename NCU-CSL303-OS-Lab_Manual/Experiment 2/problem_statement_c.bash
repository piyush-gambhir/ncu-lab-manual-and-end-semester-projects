: '
Problem Statement: 
c) Write a shell program to find gross salary of an employee.
'

#!/bin/bash

read -p "Enter Basic Salary: " basic

hra=$(echo "0.20 * $basic" | bc)
da=$(echo "0.30 * $basic" | bc)

gross=$(echo "$basic + $hra + $da" | bc)

echo "Gross Salary is: $gross"
