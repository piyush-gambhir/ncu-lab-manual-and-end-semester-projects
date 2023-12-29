: '
Problem Statement: 
b) Write a shell program to find factorial of a number. 
'

#!/bin/bash

factorial() {
    if [ $1 -le 1 ]; then
        echo 1
    else
        last=$(factorial $(( $1 - 1 )))
        echo $(( $1 * last ))
    fi
}

read -p "Enter a number: " num
result=$(factorial $num)
echo "Factorial of $num is: $result"
