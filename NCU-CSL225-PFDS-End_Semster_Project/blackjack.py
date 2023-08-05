"""
Project Problem Statement

Create a blackjack CUI game for the player, keeping all the rules in mind. The dealer here would be a computer. 
The choice of deck could be one, two or maximum three. If you are good at probability, you may apply that.
"""


# Importing Required Modules
import os
import time
import random


"""
BlackJack Game

Blackjack is the most widely played casino game in the world. It falls under the category of comparing-card games and is usually played between several players and a dealer. Each player, in turn, competes against the dealer, but players do not play against each other. In Blackjack, all players and the dealer try to build a hand that totals 21 points without going over. The hand closest to 21 wins.

Blackjack is played with one or more standard 52-card decks. The standard deck has 13 ranks in 4 suits.

Background

To start with, the players and the dealer are dealt separate hands. Each hand has two cards in it.
The dealer has one card exposed (the up card) and one card concealed (the hole card), leaving the player with incomplete information about the state of the game.
The player's objective is to make a hand that has more points than the dealer, but less than or equal to 21 points.
The player is responsible for placing bets when they are offered, and taking additional cards to complete their hand.
The dealer will draw additional cards according to a simple rule: when the dealer's hand is 16 or less, they will draw cards (called a hit), when it is 17 or more, they will not draw additional cards (or stand pat).
Points calculation

Blackjack has different point values for each of the cards:

The number cards (2-10) have the expected point values.
The face cards (Jack, Queen, and King) all have a value of 10 points.
The Ace can count as one point or eleven points. Because of this, an Ace and a 10 or face card totals 21. This two-card winner is called “blackjack”.
When the points include an ace counting as 11, the total is called soft-total; when the ace counts as 1, the total is called hard-total. For example, A+5 can be considered a soft 16 or a hard 6.
Gameplay

The player places an initial bet.
The player and dealer are each dealt a pair of cards.
Both of the player's cards are face up, the dealer has one card up and one card down.
If the dealer's card is an ace, the player is offered insurance.
Initially, the player has a number of choices:

If the two cards are the same rank, the player can elect to split into two hands.
The player can double their bet and take just one more card.
The more typical scenario is for the player to take additional cards (a hit ) until either their hand totals more than 21 (they bust ), or their hand totals exactly 21, or they elect to stand.
If the player's hand is over 21, their bet is resolved immediately as a loss. If the player's hand is 21 or less, it will be compared to the dealer's hand for resolution.

Dealer has an Ace: If the dealer's up card is an ace, the player is offered an insurance bet. This is an additional proposition that pays 2:1 if the dealer's hand is exactly 21. If this insurance bet wins, it will, in effect, cancel the loss of the initial bet. After offering insurance to the player, the dealer will check their hole card and resolve the insurance bets. If the hole card is a 10-point card, the dealer has blackjack, the card is revealed, and insurance bets are paid. If the hole card is not a 10-point card, the insurance bets are lost, but the card is not revealed.

Split Hands: When dealt two cards of the same rank, the player can split the cards to create two hands. This requires an additional bet on the new hand. The dealer will deal an additional card to each new hand, and the hands are played independently. Generally, the typical scenario described above applies to each of these hands.

Bets

Ante: This is the initial bet and is mandatory to play.
Insurance: This bet is offered only when the dealer shows an ace. The amount must be half the ante.
Split: This can be thought of as a bet that is offered only when the player's hand has two cards of equal rank. The amount of the bet must match the original ante.
Double: This can be thought of as a bet that is offered instead of taking an ordinary hit. The amount of the bet must match the original ante.

"""


# Function to clear the terimanl
def clear_terminal():
    os.system('cls' if os.name == 'nt' else 'clear')

# Card class to create card objects


class Card():
    def __init__(self, suit, card, card_score_value):

        # Suit of the Card like Spades, Clubs, Diamonds, Hearts
        self.__suit = suit

        # Representing the card like 2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace
        self.__card = card

        # Score value of the card
        self.__card_score_value = card_score_value

    def get_suit(self):
        return self.__suit

    def get_card(self):
        return self.__card

    def get_card_score_value(self):
        return self.__card_score_value

    def set_card_score_value(self, card_score_value):
        self.__card_score_value = card_score_value

# Function to create deck of cards


def deck():
    suits = ['Clubs', 'Diamonds', 'Hearts', 'Spades']

    cards = ['2', '3', '4', '5', '6', '7', '8',
             '9', '10', 'Jack', 'Queen', 'King', 'Ace']

    card_values = {'2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8,
                   '9': 9, '10': 10, 'Jack': 10, 'Queen': 10, 'King': 10, 'Ace': 11}
    deck = []
    for suit in suits:
        for card in cards:
            deck.append(Card(suit, card, card_values[card]))
    return deck

# Function to print the cards


def print_cards(cards, hidden):

    suit_symbols = {"Spades": "♠", "Hearts": "♥",
                    "Clubs": "♣", "Diamonds": "♦"}

    card_symbols = {"2": "2", "3": "3", "4": "4", "5": "5", "6": "6", "7": "7", "8": "8", "9": "9", "10": "10",
                    "Jack": "J", "Queen": "Q", "King": "K", "Ace": "A"}

    s = ""
    for card in cards:
        if (hidden):
            s += "\t ________________"
        else:
            s += "\t ________________"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|                |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|                |"
        else:
            if (card.get_card()) == '10':
                s = s + \
                    "\t|  {}            |".format(
                        card_symbols[card.get_card()])
            else:
                s = s + \
                    "\t|  {}             |".format(
                        card_symbols[card.get_card()])
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|      * *       |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|    *     *     |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|   *       *    |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|   *       *    |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|          *     |"
        else:
            s += "\t|       {}        |".format(suit_symbols[card.get_suit()])
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|         *      |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|        *       |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|        *       |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|        *       |"
        else:
            s += "\t|                |"
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|                |"
        else:
            if (card.get_card() == '10'):
                s += "\t|            {}  |".format(
                    card_symbols[card.get_card()])
            else:
                s += "\t|            {}   |".format(
                    card_symbols[card.get_card()])
    print(s)

    s = ""
    for card in cards:
        if (hidden):
            s += "\t|________________|"
        else:
            s += "\t|________________|"
    print(s)
    print()


def play_game(deck):
 # Cards for both dealer and player
    player_cards = []
    dealer_cards = []

    # Scores for both dealer and player
    player_score = 0
    dealer_score = 0

    clear_terminal()

    # Initial dealing for player and dealer
    while len(player_cards) < 2:

        # Randomly dealing a card to player
        player_card = random.choice(deck)
        player_cards.append(player_card)
        deck.remove(player_card)

        # Updating the player score
        player_score += player_card.get_card_score_value()

        # In case both the cards are Ace, make the first ace value as 1
        if len(player_cards) == 2:
            if player_cards[0].get_card_score_value() == 11 and player_cards[1].get_card_score_value() == 11:
                player_cards[0].set_card_score_value(1)
                player_score -= 10

        # Randomly dealing a card to dealer
        dealer_card = random.choice(deck)
        dealer_cards.append(dealer_card)
        deck.remove(dealer_card)

        # Updating the dealer score
        dealer_score += dealer_card.get_card_score_value()

        # In case both the cards are Ace, make the second ace value as 1
        if len(dealer_cards) == 2:
            if dealer_cards[0].get_card_score_value() == 11 and dealer_cards[1].get_card_score_value() == 11:
                dealer_cards[1].set_card_score_value(1)
                dealer_score -= 10

    check_blackjack(player_cards, player_score, dealer_cards, dealer_score)

    # Managing the player moves
    if (player_score < 21):
        clear_terminal()

        print("DEALER CARDS: ")
        print_cards(dealer_cards, True)

        print()

        print_player_cards_and_score(player_cards, player_score, False)

        choice = input("Enter H to Hit or S to Stand : ")

        # Checking for invalid input
        if len(choice) != 1 or (choice.upper() != 'H' and choice.upper() != 'S'):
            clear_terminal()
            print("Invalid Choice! Try Again")

        # If player decides to HIT
        if choice.upper() == 'H':

            # Dealing a new card
            player_card = random.choice(deck)
            player_cards.append(player_card)
            deck.remove(player_card)

            # Updating player score
            player_score += player_card.get_card_score_value()

            # Updating player score in case player's card have ace in them
            c = 0
            while player_score > 21 and c < len(player_cards):
                if player_cards[c].get_card_score_value() == 11:
                    player_cards[c].set_card_score_value(1)
                    player_score -= 10
                    c += 1
                else:
                    c += 1

            # Checking for blackjack
            check_blackjack(player_cards, player_score,
                            dealer_cards, dealer_score)

        # If player decides to Stand
        if choice.upper() == 'S':
            print("Player Stands")
            print("Dealer's Turn")

    # Managing the dealer moves
    while dealer_score < 17:
        clear_terminal()

        print("DEALER DECIDES TO HIT")
        # Dealing card for dealer
        dealer_card = random.choice(deck)
        dealer_cards.append(dealer_card)
        deck.remove(dealer_card)

        # Updating the dealer's score
        dealer_score += dealer_card.get_card_score_value()

        # Updating player score in case player's card have ace in them
        c = 0
        while dealer_score > 21 and c < len(dealer_cards):
            if dealer_cards[c].get_card_score_value() == 11:
                dealer_cards[c].set_card_score_value(1)
                dealer_score -= 10
                c += 1
            else:
                c += 1

    # Checking for blackjack
    check_blackjack(player_cards, player_score, dealer_cards, dealer_score)

    # print player and dealer cards
    print_player_cards_and_score(player_cards, player_score, False)
    print()
    print("DEALER CARDS: ")
    print_cards(dealer_cards, False)

    # Checking for the winner
    check_winner(player_score, dealer_score)


# Print dealer cards and score
def print_dealer_cards_and_score(dealer_cards, dealer_score, hidden):
    print("DEALER CARDS: ")
    print_cards(dealer_cards[:-1], hidden)
    print("DEALER SCORE = ", dealer_score -
          dealer_cards[-1].get_card_score_value())


# Print player cards and score
def print_player_cards_and_score(player_cards, player_score, hidden):
    print("PLAYER CARDS: ")
    print_cards(player_cards, hidden)
    print("PLAYER SCORE = ", player_score)

# Check if player or dealer has blackjack


def check_blackjack(player_cards, player_score, dealer_cards, dealer_score):
    if player_score == 21:
        clear_terminal()
        print_player_cards_and_score(player_cards, player_score, False)
        print_dealer_cards_and_score(dealer_cards, dealer_score, False)
        print("BLACKJACK! YOU WIN!")
        play_again()
    # Dealer gets a blackjack
    if dealer_score == 21:
        clear_terminal()
        print_player_cards_and_score(player_cards, player_score, False)
        print_dealer_cards_and_score(dealer_cards, dealer_score, False)
        print("DEALER HAS A BLACKJACK! PLAYER LOSES!")
        play_again()


def check_winner(player_score, dealer_score):

    # Checking for dealer's win
    if player_score > 21:
        print("PLAYER BUSTED! GAME OVER!")
        play_again()

    # Checking for player's win
    if dealer_score > 21:
        print("DEALER BUSTED! YOU WIN!")
        play_again()

    # Checking for tie
    if dealer_score == player_score:
        print("\n")
        print("TIE GAME!")
        play_again()

    # Player Wins
    elif player_score > dealer_score:
        print("\n")
        print("PLAYER WINS!")
        play_again()

    # Dealer Wins
    else:
        print("\n")
        print("DEALER WINS!")
        play_again()


def play_again():
    choice = input("Do you want to play again? (Y/N) : ")
    if choice.upper() == 'Y':
        main()
    else:
        quit()


def main():

    print("""
====================================
Welcome to the game of Blackjack
====================================
    """)
    if (input("Do you want to play a game of Blackjack? (Y/N) ").upper() == 'Y'):
        clear_terminal()
        # Creating a deck of cards
        card_deck = deck()

        # Starting the game
        play_game(card_deck)
    else:
        print("Thanks for playing")
        quit()


main()