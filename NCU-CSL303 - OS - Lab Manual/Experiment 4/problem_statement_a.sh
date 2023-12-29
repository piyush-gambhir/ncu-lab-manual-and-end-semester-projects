: '
Problem Statement: 
a) Write a shell program to check whether a number is even or odd
'

read -p "Enter a number: " num

if [ $((num%2)) -eq 0 ]
then
    echo "The number is even"
else
    echo "The number is odd"
fi
