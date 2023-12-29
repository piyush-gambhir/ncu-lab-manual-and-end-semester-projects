"""
Experiment 6
Write Python Program to Implement Laws of Probability
"""

# Addition Law of Probability
def addition_law(a, b):
    return a + b - (a * b)

# Multiplication Law of Probability
def multiplication_law(a, b):
    return a * b

# Conditional Probability
def conditional_probability(a, b):
    return (a * b) / b

# Total Probability Theorem
def total_probability_theorem(probability):
         
    event = int(input("Enter the Event Number: "))
    probability_event = 0
    for i in range(len(probability)):
        probability_event_given_i = conditional_probability(probability[event-1], probability[i])
        probability_event += probability[i] * probability_event_given_i

    print("\nThe Probability if the {} is : {}".format(event, probability_event))
    

# Complement of an Event
def complement(a):
    return 1 - a


def main():
    # Menu for user to choose which law of probability to use
    print("1. Addition Law of Probability")
    print("2. Multiplication Law of Probability")
    print("3. Conditional Probability")
    print("4. Complement of an Event")
    print("5. Total Probability Theorem")
    print("6. Exit")
    choice = int(input("\nEnter Your Choice: "))

    # Addition Law of Probability
    if choice == 1:
        a = float(input("Enter the probability of event A: "))
        b = float(input("Enter the probability of event B: "))

        if(a > 1 or b > 1):
            print("Probability cannot be greater than 1")
            exit()
        print("\n")
        print("P(A or B) = ", addition_law(a, b))

    # Multiplication Law of Probability
    elif choice == 2:
        a = float(input("Enter the probability of event A: "))
        b = float(input("Enter the probability of event B: "))
        if(a > 1 or b > 1):
            print("Probability cannot be greater than 1")
            exit()
        print("\n")
        print("P(A and B) = ", multiplication_law(a, b))

    # Conditional Probability
    elif choice == 3:
        a = float(input("Enter the probability of event A: "))
        b = float(input("Enter the probability of event B: "))
        if(a > 1 or b > 1):
            print("Probability cannot be greater than 1")
            exit()
        print("\n")
        print("P(A | B) = ", conditional_probability(a, b))

    # Complement of an Event
    elif choice == 4:
        a = float(input("Enter the probability of event A: "))
        print("P(not A) = ", complement(a))

    # Total Probability Theorem
    elif choice == 5:
        probability = []
        number_of_events = int(input("Enter the number of events: "))
        for i in range(number_of_events):
            inp = float(input("Enter the probability of event {}: ".format(i + 1)))
            if(inp > 1):
                print("Probability cannot be greater than 1")
                exit()
            probability.append(inp)
            
    # Exit
    elif choice == 6:
        exit()

    # Invalid Choice
    else:
        print("Invalid Choice")


main()
