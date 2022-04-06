import java.util.ArrayList;
import java.util.Scanner;

public class Player{
    
    private ArrayList<Card> hand; // the player's hand
    private Scanner input;

    public Player(){
        // your code here
    }

    // Adds a card to the player's hand
    public void addCard(Card c){
        // your code here
    }
   
    // Covers all the logic regarding a human player's turn
    // public so it may be called by the Game class
    public Card playsTurn(Deck deck){
        boolean canPlay = false;


        System.out.println("Enter the card number to play. Enter 0 to draw another card");

        int playercard = input.nextInt();
        while(playercard==0){
            if(deck.canDeal()) {
                hand.add(deck.deal());
            }else{
                System.out.println("Deck is empty");
                return null;
            }
            playercard = input.nextInt();
        }

        return hand.remove(playercard+1);
    }

    
    // Accessor for the players hand
    public ArrayList<Card> getHand(){
        // your code here
    }

    // Returns a printable string representing the player's hand
    public String handToString(){
        // your code here
    }

    // you will likely wish to have several more helper methods to simplify
    // and shorten the methods above.

} // end
