import java.util.ArrayList;
import java.util.Scanner;

public class Player{
    
    private ArrayList<Card> hand; // the player's hand
    private Scanner input;

    public Player(){
        input = new Scanner(System.in);
        hand = new ArrayList<Card>(7);

    }

    // Adds a card to the player's hand
    public void addCard(Card c){
        hand.add(c);
    }
   
    // Covers all the logic regarding a human player's turn
    // public so it may be called by the Game class
    public Card playsTurn(Deck deck){
        int playercard = -1;
        while(true) {
            playercard = -1;
            System.out.println("Enter the card number to play. Enter 0 to draw another card");
            while(playercard<0 || playercard> hand.size()) {
                playercard = input.nextInt();
            }
            if (playercard == 0) {
                if (deck.canDeal()) {
                    hand.add(deck.deal());
                    System.out.println(handToString());
                    continue;
                } else {
                    System.out.println("Deck is empty");
                    return null;
                }
            }else if(Game.verifyCard(hand.get(playercard-1))){

                break;
            }
            System.out.println("Illegal move try again");
        }

        return hand.remove(playercard-1);
    }

    
    // Accessor for the players hand
    public ArrayList<Card> getHand(){
        return hand;
    }

    // Returns a printable string representing the player's hand
    public String handToString(){
        String output="\nYour current hand has\n";
        for(int i=0; i<hand.size(); i++){
            output +=1+i+". "+hand.get(i).toString()+"\n";
        }
        return output;
    }

    // you will likely wish to have several more helper methods to simplify
    // and shorten the methods above.

} // end
