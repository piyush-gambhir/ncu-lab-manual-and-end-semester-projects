: '
Problem Statement: 
c) Write a shell program to find whether a number is palindrome or not.
'

read -p "Enter a number: " num

temp=$num
rev=0

while [ $num -gt 0 ]
do
    rem=$((num%10))
    rev=$((rev*10+rem))
    num=$((num/10))
done

if [ $temp -eq $rev ]
then
    echo "The number is palindrome"
else
    echo "The number is not palindrome"
fi

