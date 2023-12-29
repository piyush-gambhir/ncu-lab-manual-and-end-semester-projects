: '
Problem Statement: 
d) Write a shell program to type number 1 to 7 and then print its corresponding day of week
'

read -p "Enter a number: " num

case $num in
    1)
        echo "Monday"
        ;;
    2)
        echo "Tuesday"
        ;;
    3)
        echo "Wednesday"
        ;;
    4)
        echo "Thursday"
        ;;
    5)
        echo "Friday"
        ;;
    6)
        echo "Saturday"
        ;;
    7)
        echo "Sunday"
        ;;
    *)
        echo "Invalid input"
        ;;
esac