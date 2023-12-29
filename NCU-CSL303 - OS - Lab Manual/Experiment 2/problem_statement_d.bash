: '
d) Problem Statement : Write a shell program to display the menu and execute instructions accordingly:
    (i)List of files (ii)Process Status (iii) Date (iv) users in program (v) Quit 
'

#!/bin/bash

while true; do
    echo "Choose an option:"
    echo "(i) List of files"
    echo "(ii) Process Status"
    echo "(iii) Date"
    echo "(iv) Users in program"
    echo "(v) Quit"
    
    read choice

    case $choice in
        i) ls ;;
        ii) ps ;;
        iii) date ;;
        iv) who ;;
        v) exit 0 ;;
        *) echo "Invalid choice";;
    esac
done
