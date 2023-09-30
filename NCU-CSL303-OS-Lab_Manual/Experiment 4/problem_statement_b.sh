: '
Problem Statement: 
b) Write a shell program to find whether a number is prime or not.
'

read -p "Enter a number: " num

if [ $num -eq 1 ]
then
    echo "The number is neither prime nor composite"
    exit
fi

for (( i=2; i<=num/2; i++ ))
do
    if [ $((num%i)) -eq 0 ]
    then
        echo "The number is not prime"
        exit
    fi
done
