: '
Problem Statement :
c) Write a shell program to find average of N numbers.
'

#!/bin/bash

echo "Enter the value of N:"
read n

sum=0

echo "Enter $n numbers:"
for (( i=1; i<=n; i++ ))
do
    read num
    sum=$((sum + num))
done

average=$((sum / n))  

fractional_part=$((sum % n))
fractional_part=".${fractional_part}" 

echo "The average is: $average$fractional_part"

