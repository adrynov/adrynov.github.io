#!/bin/bash


echo --------------------------------------------
echo Welcome to Math Tables Generator
echo --------------------------------------------

operations=("Addition" "Subtraction" "Multiplication" "Division" "Exponent" "Exit")
operators=("+" "-" "*" "/" "^" "q")

set -f # turn off glob expansion, it messes the multiplication operation

#  --------------------------------- functions ---------------------------------

list_operations () {
     printf "\nAvailable operations:\n\n"

    for ((i = 0; i < ${#operators[@]}; i++))
    do
        printf "%-20s %2s\n" ${operations[$i]} "${operators[$i]}"
    done

    echo
}

show_error () {
    printf "\n------------------------\n"
    printf "[ERROR]: $1"
    printf "\n------------------------\n"
}

generate_table () {
    echo

    case $OPERATION in
        "+")
            table="Addition";;
        "-")
            table="Subtraction";;
        "*")
            table="Multiplication";;
        "/")
            table="Division";;
        "^")
            table="Exponent";;
    esac

    # print the Maths table
    echo "$table Table ($1 by $1)"

    for ((i = 1; i <= $1; i++)); do

        for ((j = 1; j <= $1; j++)); do 

            # division only
            # Bash doesn’t support floating-point arithmetic, 
            if [[  $OPERATION == "/" ]] ; then
                # echo "scale=2; $i / $j" | bc
                printf "%d/%d=%.2f      " $i $j $((10**2 * i/j))e-2
                # echo
                continue;
            fi

            # other operations
            case $OPERATION in
                "+")
                    result=$(($i + $j));;
                "-")
                    result=$(($i - $j));;
                "*")
                    result=$(($i * $j));;             
                "^")
                    result=$(($i ** $j));;
            esac
            
            printf "%d%s%d=%-2d      " $i $OPERATION $j $result
        done
        echo
    done

    echo ------------------------

    printf "\nOnce more? \n"
}

#  --------------------------------- main code ---------------------------------

echo "The programme will display a Maths table."
list_operations


while true ; do

    # ask to enter the operation symbol
    read -p "Enter your operation: " OPERATION

    case $OPERATION in
        # acceptable operations
        "+" | "-" | "*" | "/" | "^")             
            ;;
        # exit the program
        "q")
            printf "\nGoodbye!\n\n"
            exit ;;
        # ignore other input
        *)
            show_error "Unknown Operation"
            list_operations
            continue ;;

    esac

    # ask to enter the operand
    read -p "Enter your operand (1-15): " OPERAND
    
    # validate the operand
    [[ $OPERAND =~ ^[0-9]+$ ]] || { show_error "Please enter a number!"; continue; } 

    # check the operand range
    if (($OPERAND > 15)) ; then
        show_error "Only numbers from 1 to 15 are allowed!"
        continue
    fi

   
    # operation and operand have been provided
    generate_table $OPERAND
done
