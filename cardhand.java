{\rtf1\ansi\ansicpg1252\cocoartf1404\cocoasubrtf340
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;}
\margl1440\margr1440\vieww22240\viewh11600\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf0 \expnd0\expndtw0\kerning0
// Arup Guha\
// 9/12/02\
// Brief Description: This class uses a linked list of card objects to\
//                    simulate a hand of cards. The user is allowed to\
//                    add and delete cards from their hand, as well as\
//                    print out the cards in their hand and score their\
//                    hand.\
import java.io.*;\
// Arup Guha\
// 9/12/02\
// Brief Description: The card class defines a card object to store \
//                    information about a playing card. The information\
//                    supported is the suit and type of card, as well as\
//                    the value in the game of bridge of that card.\
class card \{\
\
  private String suit;\
  private String type;\
  private int abs_rank;\
  private int value;\
\
  // Constructor, directly assigns the sign and suit, and must \
  // initialize the other two instance variables.\
  public card(String s, String k) \{\
\
    suit = s.toLowerCase();\
    type = k.toLowerCase();\
\
    // Helps compute the value and rank of the card.\
    if (type.equals("ace")) \
      abs_rank = 14;\
    else if (type.equals("king"))\
      abs_rank = 13;\
    else if (type.equals("queen"))\
      abs_rank = 12;\
    else if (type.equals("jack"))\
      abs_rank = 11;\
    else if (type.equals("ten"))\
      abs_rank = 10;\
    else if (type.equals("nine"))\
      abs_rank = 9;\
    else if (type.equals("eight"))\
      abs_rank = 8;\
    else if (type.equals("seven"))\
      abs_rank = 7;\
    else if (type.equals("six"))\
      abs_rank = 6;\
    else if (type.equals("five"))\
      abs_rank = 5;\
    else if (type.equals("four"))\
      abs_rank = 4;\
    else if (type.equals("three"))\
      abs_rank = 3;\
    else\
      abs_rank = 2;\
\
    // Calculates the bridge value of the card from the computed rank.\
    if (abs_rank <= 10)\
      value = 0;\
    else\
      value = abs_rank % 10;\
    \
    // Assigns an unique rank for each possible playing card.\
    int temp=0;\
    if (suit.equals("diamonds"))\
      temp = 1;\
    else if (suit.equals("hearts"))\
      temp = 2;\
    else if (suit.equals("spades"))\
      temp = 3;\
  \
    abs_rank = 13*temp + (abs_rank - 1);\
\
  \}\
\
  // Accessor methods.\
  public int getvalue() \{\
    return value;\
  \}\
\
  public String getsuit() \{\
    return suit;\
  \}\
\
  public String gettype() \{\
    return type;\
  \}\
\
  public int getrank() \{\
    return abs_rank;\
  \}\
\
  // Compares two playing cards. Returns a positive number if the first\
  // card is greater than the second, 0 if they are equal, and negative\
  // if the first card is less than the second card.\
  public int compareTo(card other) \{\
    return abs_rank - other.abs_rank;\
  \}\
\
  public String toString() \{\
    return (type+" of "+suit);\
  \}\
\
\}\
// Brief Description: Maintains a node to store a card.\
class cardnode \{\
\
  public card playcard;\
  public cardnode next;\
\
  public cardnode(card c) \{\
    playcard = c;\
    next = null;\
  \}\
\
\}\
public class cardhand \{\
\
  private cardnode begin;\
\
  // Default constructor.\
  public cardhand() \{\
    begin = null;\
  \}\
\
  // Adds a card into the cardhand object.\
  public void add(card one) \{\
\
    // Creates a node to store the card.\
    cardnode c = new cardnode(one);\
    \
    // Takes care of the empty hand case.\
    if (begin == null)\
      begin = c;\
\
    // Adding a card to a hand with at least one card.\
    else \{\
\
      // Adds the new card to the beginning if necessary.\
      if ((c.playcard).compareTo(begin.playcard) > 0) \{\
        c.next = begin;\
        begin = c;\
      \}\
\
      // Adds the card to the appropriate location in the middle/end\
      // of the list.\
      else \{\
    \
        // Iterate to find the right location to add the card.\
        cardnode helper = begin;\
        while ((helper.next != null) && \
               (helper.next.playcard.compareTo(c.playcard) > 0))\
          helper = helper.next;\
\
        // Adjust the necessary references to add the card.\
        c.next = helper.next;\
        helper.next = c;\
      \}\
    \}\
\
  \}\
\
  // Removes the card one from the cardhand object if an equivalent card\
  // is in the cardhand object, and returns true in this case. If no such\
  // card is found, false is returned.\
  public boolean remove(card one) \{\
\
    // Take care of empty hand case.\
    if (begin == null)\
      return false;\
\
    // Take care of the case of deleting from the front of the list.\
    if (begin.playcard.compareTo(one) == 0) \{\
      begin = begin.next;\
      return true;\
    \}\
\
    // Iterate to the correct location in the list to perform the delete.\
    cardnode helper = begin;\
    while ((helper.next != null) && \
           (helper.next.playcard.compareTo(one) > 0))\
      helper = helper.next;\
    \
    // Check for the case that the card was not in the list because it\
    // would have been placed after the last card in the current hand.\
    if (helper.next == null)\
      return false;\
\
    // Delete the card if it is actually in the list.\
    if (helper.next.playcard.compareTo(one) == 0) \{\
      helper.next = helper.next.next;\
      return true;\
    \}\
\
    // Takes care of the other case where the card isn't in the list.\
    return false;\
  \}\
\
  // Prints out all the cards in the cardhand object in order.\
  public void printHand() \{\
\
    System.out.println();\
    cardnode helper = begin;\
    // Iterate through the entire list!!!\
    while (helper != null) \{\
      System.out.println(helper.playcard);\
      helper = helper.next;\
    \}\
  \}\
 \
  // Determines the score of the hand.\
  public int score() \{\
\
    // An array to tabulate the number of cards for each suit.\
    int [] numcards = new int[4];\
    int sum = 0, i;\
    for (i=0; i<numcards.length; i++)\
      numcards[i] = 0;\
\
    // Iterate through the cards to score each face card and keep track\
    // of how many cards are in each suit.\
    cardnode helper = begin;\
    while (helper != null) \{\
      sum += helper.playcard.getvalue();\
\
      // Suite index can be calculated from the rank of the card.\
      numcards[(helper.playcard.getrank()-1)/13]++;      \
      helper = helper.next;\
    \}\
\
    // Add extra points for void and singletons.\
    for (i=0; i<numcards.length; i++)\
      if (numcards[i] < 2)\
        sum += (2-numcards[i]);\
\
    return sum;\
  \}\
\
  public static void main(String [] args) throws IOException \{\
\
    // cardhand object to use.\
    cardhand myhand = new cardhand();\
 \
    // Loop until the user wants to quit.\
    int menuchoice = menu();    \
    while (menuchoice != 5) \{\
\
      // Add a card.\
      if (menuchoice == 1) \{\
        System.out.println();\
        String suit = getsuit("added");\
        String kind = getkind("added");\
        card temp = new card(suit,kind);\
        myhand.add(temp);\
      \}\
\
      // Delete a card.\
      else if (menuchoice == 2) \{\
        System.out.println();\
        String suit = getsuit("removed");\
        String kind = getkind("removed");\
        card temp = new card(suit,kind);\
\
        // Display error message if necesary.\
        if (!myhand.remove(temp))\
          System.out.println("Sorry, you don't have that card to remove.");\
      \}\
      else if (menuchoice == 3) \{\
        myhand.printHand();\
      \}\
      else if (menuchoice == 4) \{\
        System.out.println("Total score of your hand: "+myhand.score());\
      \}\
      menuchoice = menu();      \
    \}\
\
  \}\
\
  // Ask the user for the suit of a card.\
  public static String getsuit(String action) throws IOException \{\
\
    BufferedReader stdin = new BufferedReader\
                           (new InputStreamReader(System.in));\
  \
    System.out.println("What is the suit of the card to be "+action+"?");\
    String ans = stdin.readLine();\
    return ans;\
  \}\
\
  // Ask the user for the type/kind of the card.\
  public static String getkind(String action) throws IOException \{\
\
    BufferedReader stdin = new BufferedReader\
                           (new InputStreamReader(System.in));\
  \
    System.out.println("What is the kind of the card to be "+action+"?");\
    String ans = stdin.readLine();\
    return ans;\
  \}\
\
\
  // Prompts the user with the menu and returns their choice.\
  public static int menu() throws IOException \{\
\
    BufferedReader stdin = new BufferedReader\
                           (new InputStreamReader(System.in));\
\
    int ans=0;\
    boolean done = false;\
\
    while (!done) \{\
      System.out.println();\
      System.out.println("Here are your menu choices.");\
      System.out.println("1. Add a card to your hand.");\
      System.out.println("2. Delete a card from your hand.");\
      System.out.println("3. Print out a list of all of yoru cards, in order.");\
      System.out.println("4. Print out the score of your hand.");\
      System.out.println("5. Quit");\
\
      ans = Integer.parseInt(stdin.readLine());\
      if (ans >= 1 && ans <=5)\
        done = true;\
      else\
        System.out.println("That was an invalid choice. Please try again.");\
    \}\
    return ans;  \
  \}\
\
\}}